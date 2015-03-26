package laserChess;

import java.awt.Color;

import javax.swing.JPanel;

public class GuiPanel extends JPanel {

	public GuiPanel() {
		this.setLayout(null);
		this.setBounds(0, 0, LaserChess.frameWidth, LaserChess.frameHeight);
		this.setBackground(Color.RED);
	}
}
