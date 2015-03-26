package drivingLoop.framework;

import java.util.LinkedList;
import java.util.List;

public class Route {
	List<GasStation> route = new LinkedList<GasStation>();
	
	public Route(){
		
	}
public Route(GasStation gs){
	
		route.add(gs);
	}
public void addGasStation(GasStation gs){
	route.add(gs);
}
public int getLength(){
	return route.size();
}

public GasStation getStation(int i){
	GasStation gs;
	gs = route.get(i);
	return gs;
}

}
