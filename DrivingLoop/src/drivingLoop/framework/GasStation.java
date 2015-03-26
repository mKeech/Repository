/**
 * 
 */
package drivingLoop.framework;

/**
 * @author Marty Keech
 *
 */
public class GasStation {

int amount = 0;
int prevDistance;
int NextDistance;


public GasStation() {
	
}

public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public int getPrevDistance() {
	return prevDistance;
}
public void setPrevDistance(int prevDistance) {
	this.prevDistance = prevDistance;
}
public int getNextDistance() {
	return NextDistance;
}
public void setNextDistance(int nextDistance) {
	NextDistance = nextDistance;
}


}
