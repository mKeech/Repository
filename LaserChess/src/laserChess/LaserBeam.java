package laserChess;

/*
 * LaserBeam has starting point, ending point, and angle
 */
import java.awt.Point;
import java.util.ArrayList;


public class LaserBeam {
	Point p1, p2;	
	public int angle;
	public double  x,y,x1,y1;
	public ArrayList<Point> beamPoints;
	
    // Put the starting point in the list of points, determine the ending next point and add it to the list,
	// and do this for ten segments 
    	
	public  LaserBeam(Point p, int angle) {
		beamPoints = new ArrayList<Point>();
		angle = angle;
		p1=p;		
		beamPoints.add(p1);
		for (int i=0;i<11  ;i++) {
			p2 = nextPoint(p1);
			beamPoints.add(p2);
			p1 = p2;
		}		
	}	
	public ArrayList<Point> getPoints(){
	return beamPoints;
	}
	
	/*
	 *given the first point and the angle, return the second point and set the new reflected angle. 
	 */
	private Point nextPoint(Point p1){
		Point p2;
		p2 = new Point();
		double x,y;		
		double tanAngle = Math.tan(Math.toRadians(angle)); 
		
		int dx = 0;
		int dy = 0;
				
		x = p1.getX();
		y = p1.getY();		
		if ((angle==0)||(angle==360)){			
			p2.setLocation(laserChess.LaserChess.boardWidth, y);
			angle = 180;
		}
		else if ((angle>0) &&(angle<90)){
			dx = laserChess.LaserChess.boardWidth-(int)x;
			dy = (int)(dx*tanAngle);
			if (dy<y){ // hit the right wall
				p2.setLocation(laserChess.LaserChess.boardWidth, y-dy);	
				angle = 180 - angle;
			}
			else {// hit the top wall
				dx = (int)(y/tanAngle);
				p2.setLocation(x + dx, 0);
				angle = 360 - angle;
			}			
		}
		else if (angle==90){
			p2.setLocation(x, 0);
			angle = 270;
		}
		else if ((angle>90) &&(angle<180)){
			angle=angle-90;			
			dx = (int)(y/tanAngle);
			
			if (Math.abs(dx)<x){ // hit the top wall
				p2.setLocation(x+ dx, 0);	
				angle = 270 - angle;
			}
			else {// hit the left wall
				dy = (int)(x*tanAngle);
				p2.setLocation(0, y+dy);
				angle = 90 - angle;
			}			
		}
		else if (angle==180){
			p2.setLocation(0, y);	
			angle = 0;
		}
		else if ((angle>180) &&(angle<270)){
			angle=angle-180;									
			dy = (int)(x*tanAngle);
			if (dy<laserChess.LaserChess.boardHeight - y){ // hit the left wall
				p2.setLocation(0, y + dy);	
				angle = 360 - angle;
			}
			else {// hit the bottom wall
				dy = (int)(laserChess.LaserChess.boardHeight - y);
				dx = (int)(dy/tanAngle);
				p2.setLocation(x-dx, laserChess.LaserChess.boardHeight);
				angle = 180 - angle;
			}			
		}
		
		else if (angle==270){
			p2.setLocation(x, laserChess.LaserChess.boardHeight);	
			angle = 90;
		}
		
		else if ((angle>270) &&(angle<360)){ 
			angle=360-angle;									
			dx = (int)((laserChess.LaserChess.boardHeight-y)/tanAngle);
			
			if (Math.abs(dx) +x < laserChess.LaserChess.boardWidth){ // hit the bottom wall
				p2.setLocation(x-dx, laserChess.LaserChess.boardHeight);	
				
			}
			else {// hit the right wall
				dx = (int)(laserChess.LaserChess.boardWidth - x);
				dy = (int)(dx*tanAngle);
				p2.setLocation(laserChess.LaserChess.boardWidth, y-dy);
				angle = 180 + angle;
			}			
		}
		
		return p2;
	}
	
		
		
	
	public Point getEndPoint(){
		return p2;
	}
	public Point getStartPoint(){
		return p1;
	}
        
    }
