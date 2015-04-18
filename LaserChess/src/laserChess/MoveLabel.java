package laserChess;

import java.awt.Color;
import javax.swing.JLabel;

public class MoveLabel extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2915955290873746560L;

	public MoveLabel(){
		this.setLocation(6, 2);
		this.setSize(120, 20);
		this.setText(" = MOVE =");
		this.setForeground(Color.WHITE);
		this.setFont(this.getFont().deriveFont(20f));		
	}
}
