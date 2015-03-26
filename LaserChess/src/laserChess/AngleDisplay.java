package laserChess;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AngleDisplay extends JTextField {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6699285943401135806L;

	public AngleDisplay(int columns) {
        this.setColumns(columns);
		this.setLayout(null);
		this.setBounds(LaserChess.rightOffSet + LaserChess.shootWidth + 40,
				LaserChess.boardHeight + 10, LaserChess.angleWidth,
				LaserChess.angleHeight);
		this.setBackground(Color.BLACK);
		this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		this.setForeground(Color.WHITE);
		this.setFont(this.getFont().deriveFont(20f));
		this.setHorizontalAlignment(SwingConstants.RIGHT);
		this.setText(String.valueOf(LaserChess.shotAngle));

	}
}