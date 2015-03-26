package drivingLoop.framework;

public class Car {
	float mpg = 1f;
	int gasSupply = 0;
	public Car() {
		
		this.mpg = 1f;
		
	}
	public Car(float mpg) {
		
		this.mpg = mpg;
		
	}
	public float getMpg() {
		return mpg;
	}
	public void setMpg(float mpg) {
		this.mpg = mpg;
	}
	public int getGasSupply() {
		return gasSupply;
	}
	public void setGasSupply(int gasSupply) {
		this.gasSupply = gasSupply;
	}
	public int addGasSupply(int amount) {
		this.gasSupply = gasSupply + amount;
		return gasSupply;
	}
	

}
