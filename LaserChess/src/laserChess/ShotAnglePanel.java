package laserChess;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ShotAnglePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8916967206533083546L;

	public ShotAnglePanel() {
		this.setLayout(null);
		this.setBounds(LaserChess.rightOffSet, LaserChess.boardHeight + 10, LaserChess.shootWidth, LaserChess.shootHeight);
		this.setBackground(Color.BLACK);
		this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));		
	}
}
