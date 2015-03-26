package laserChess;

import java.awt.Color;

import javax.swing.JLabel;

public class ShootLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8787122658997697346L;

	public ShootLabel() {
		this.setLocation(6, 2);
		this.setSize(LaserChess.shootWidth - 12, 20);
		this.setText("ANGLE");
		this.setForeground(Color.WHITE);
		this.setFont(this.getFont().deriveFont(20f));
	}
}
