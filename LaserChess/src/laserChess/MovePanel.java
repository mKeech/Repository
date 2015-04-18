package laserChess;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MovePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7374009402526786316L;

	public MovePanel(){		
		this.setLayout(null);
		this.setBounds(5, LaserChess.boardHeight + 10, LaserChess.moveWidth, LaserChess.moveHeight);
		this.setBackground(Color.BLACK);
		this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
	}
}
