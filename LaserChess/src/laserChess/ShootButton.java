package laserChess;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ShootButton extends JButton implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4509945103554349363L;
	public ShootButton(){
		this.setLocation(0, 0);
		this.setSize(LaserChess.sBWidth, LaserChess.sBHeight);
		this.addActionListener(this);
	}
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == this) {// take the shot
				LaserChess.p1Center = new Point(LaserChess.player1.getX() + (LaserChess.p1Size / 2), LaserChess.player1.getY()
						+ (LaserChess.p1Size / 2));
				LaserBeam laserBeam = new LaserBeam(LaserChess.p1Center, LaserChess.shotAngle);			
			LaserChess.gameBoard.repaint();
			}
		}				
	}
