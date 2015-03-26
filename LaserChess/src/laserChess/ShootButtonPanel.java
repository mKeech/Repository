package laserChess;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class ShootButtonPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 187345843390890508L;

	public ShootButtonPanel(){
		this.setLayout(null);
		this.setBounds(LaserChess.moveWidth + 10, LaserChess.boardHeight + LaserChess.moveHeight + 15,
				LaserChess.sBWidth, LaserChess.sBHeight);
		this.setBackground(Color.BLACK);
		this.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
		// creation of the Shoot Button
				ShootButton shootButton = new ShootButton();				
				this.add(shootButton);
		
	}


	

}
