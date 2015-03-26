package laserChess;


import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {	
	public int status;
	public int x,y;
	public static BufferedImage playerImage;
	public static BufferedImage p10;
    public static BufferedImage p11;
    public static BufferedImage p12;
    public static BufferedImage p13;
    public static BufferedImage p14;
    public static BufferedImage p15;
    public Point center;
    
    	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		center = new Point(x,y);
		status = 0;
		getImages();
	}

	public void hitWall() {
		status++;
		if (status == 1) {// first hit
			playerImage = p11;
		} else if (status == 2) {
			playerImage = p12;
		}
	     else if (status == 3) {
		       playerImage = p13;
	    }
	     else if (status == 4) {
		       playerImage = p14;
	    }
	     else {
	    	 playerImage = p15;
	     }
	}
	public void setX(int x){
		this.x = x;
	}
	public int getX(){
		return x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getY(){
		return y;
	}
	public int getStatus(){
		return status;
	}
	public Point getCenter(){
		center = new Point(x,y);
		return center;
		
	}
	public BufferedImage  getImage(){
		return playerImage;
	}
		
	
    private void getImages() {

    	try {
			p10 = ImageIO.read(new File("C:/Users/Marty/workspace/LaserChess/src/images/smilingStar0.png"));
			p11 = ImageIO.read(new File("C:/Users/Marty/workspace/LaserChess/src/images/smilingStar1.png"));			
			p12 = ImageIO.read(new File("C:/Users/Marty/workspace/LaserChess/src/images/smilingStar2.png"));			
			p13 = ImageIO.read(new File("C:/Users/Marty/workspace/LaserChess/src/images/smilingStar3.png"));			
			p14 = ImageIO.read(new File("C:/Users/Marty/workspace/LaserChess/src/images/smilingStar4.png"));			
			p15 = ImageIO.read(new File("C:/Users/Marty/workspace/LaserChess/src/images/smilingStar5.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	      
    }
}

