package drivingLoop.framework;

public class EvaluateRoute {

	Route route;
	GasStation gs0;
	GasStation gs1;
	GasStation gs2;
	GasStation gs3;
	Car car;

	private void createGasStations() {
		gs0 = new GasStation();
		gs1 = new GasStation();
		gs2 = new GasStation();
		gs3 = new GasStation();

		this.gs0.setAmount(3);
		this.gs0.setPrevDistance(5);
		this.gs0.setNextDistance(8);

		this.gs1.setAmount(6);
		this.gs1.setPrevDistance(8);
		this.gs1.setNextDistance(3);

		this.gs2.setAmount(4);
		this.gs2.setPrevDistance(3);
		this.gs2.setNextDistance(4);

		this.gs3.setAmount(7);
		this.gs3.setPrevDistance(4);
		this.gs3.setNextDistance(5);
		
		

	}

	private void createRoute() {
		route = new Route(gs0);
		this.route.addGasStation(gs1);
		this.route.addGasStation(gs2);
		this.route.addGasStation(gs3);

	}

	private void createCar() {
		car = new Car();
		car.setMpg(1);
		car.setGasSupply(0);
		int gs = car.getGasSupply();

	}

	private void evaluateRoute() {
		this.createCar();
		this.createGasStations();
		this.createRoute();
		int routeLength = this.route.getLength();
		int gasAmount = 0;
		GasStation gs;

		boolean done = false;
		int location = 0;

		for (int i = 0; i < routeLength; i++) {
			// try starting at position i, clockwise
			done = false;
			this.car.setGasSupply(0);
			for (int distanceTraveled = 0; (distanceTraveled < routeLength)
					&& (!done); distanceTraveled++) {
				location = (i + distanceTraveled) % routeLength;

				gs = this.route.getStation(location);
				this.car.setGasSupply(this.car.getGasSupply() + gs.getAmount());
				if (this.car.getGasSupply() < gs.getNextDistance()) {
					// can't make the next distance

					done = true;
				} else {
					this.car.setGasSupply(this.car.getGasSupply()
							- gs.getNextDistance());

				}

			}
			if (done) {
				System.out.printf("%s %d %s %d %n",
						"Clockwise Failed! Starting location: ", i,
						" at Station: ", location);
			} else {
				System.out.printf("%s %d %n",
						"Clockwise Success! Starting Location : ", i);
			}
			this.car.setGasSupply(0);
			done = false;
			for (int distanceTraveled = 0; (Math.abs(distanceTraveled) < routeLength)
					&& (!done); distanceTraveled--) {
				location = (i + distanceTraveled) % routeLength;
				if (location < 0) {
					location = location + routeLength;
				}

				gs = this.route.getStation(location);
				this.car.setGasSupply(this.car.getGasSupply() + gs.getAmount());

				if (this.car.getGasSupply() < gs.getPrevDistance()) {
					// can't make the next distance

					done = true;
				} else {
					this.car.setGasSupply(this.car.getGasSupply()
							- gs.getPrevDistance());
				}
			}
			if (done) {
				System.out.printf("%s %d %s %d %n",
						"CounterClockwise Failed! Starting location: ", i,
						" at Station: ", location);
			} else {
				System.out.printf("%s %d %n",
						"CounterClockwise Success! Starting location : ", i);
			}
		}
	}

	public static void main(String[] args) {
		// evaluate the route given

		new EvaluateRoute().evaluateRoute();

	}

}
