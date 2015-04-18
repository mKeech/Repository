package laserChess;

import java.awt.Color;

import javax.swing.*;
import javax.swing.event.ChangeEvent;

public class AngleSlider extends JSlider {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AngleSlider(int orientation, int min, int max, int initValue) {
		this.setOrientation(orientation);
		this.setMinimum(min);
		this.setMaximum(max);
		this.setValue(initValue);
		this.setLayout(null);
		this.setBounds(LaserChess.rightOffSet, LaserChess.boardHeight
				+ LaserChess.moveHeight + 15, LaserChess.shootSliderWidth,
				LaserChess.shootSliderHeight);
		this.setFont(LaserChess.font);
		this.setLabelTable(this.createStandardLabels(90));
		this.setMajorTickSpacing(90);
		this.setMinorTickSpacing(45);
		this.setPaintTicks(true);
		this.setPaintLabels(true);
		this.setBackground(Color.BLACK);
		this.setForeground(Color.WHITE);
		this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
	}

}
