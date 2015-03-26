package laserChess;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoveButtonsPanel extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7817303545480364808L;

	JLabel buttonArrrayLabel;
	ImageIcon bArrayIcon = new ImageIcon(
			"C:/Users/Marty/workspace/LaserChess/src/images/buttonGrid5x5a.png");
	
	JButton b1, b2, b3, b4, b5, b6, b7, b8;
	public MoveButtonsPanel(){
		
		JLabel buttonArrayLabel = new JLabel(bArrayIcon);	
		
		this.setLayout(null);
		this.setOpaque(true);
		this.setBackground(Color.WHITE);
		this.setBounds(5, LaserChess.boardHeight + LaserChess.moveHeight + 15, LaserChess.buttonsWidth,
				LaserChess.buttonsHeight);
		buttonArrayLabel.setLocation(0, 0);
		buttonArrayLabel.setSize(LaserChess.buttonsWidth, LaserChess.buttonsHeight);
		this.add(buttonArrayLabel);
		newButtons();
		
	}
	public void newButtons() {
		ImageIcon buttonIcon = new ImageIcon(
				"C:/Users/Marty/workspace/LaserChess/src/images/whiteButton.png");
		JLabel buttonLabel = new JLabel(buttonIcon);		
		// Create each button with an action listener.
				b1 = new JButton();
				b1.setLocation(28, 4);
				b1.setSize(19, 19);
				b1.addActionListener(this);
				b1.add(buttonLabel);
				this.add(b1);
				b2 = new JButton();
				b2.setLocation(76, 4);
				b2.setSize(19, 19);
				b2.addActionListener(this);
				this.add(b2);				
				b3 = new JButton();
				b3.setLocation(4, 28);
				b3.setSize(19, 19);
				b3.addActionListener(this);
				this.add(b3);
				b4 = new JButton();
				b4.setLocation(100, 28);
				b4.setSize(19, 19);
				b4.addActionListener(this);
				this.add(b4);
				b5 = new JButton();
				b5.setLocation(4, 76);
				b5.setSize(19, 19);
				b5.addActionListener(this);
				this.add(b5);
				b6 = new JButton();
				b6.setLocation(100, 76);
				b6.setSize(19, 19);
				b6.addActionListener(this);
				this.add(b6);
				b7 = new JButton();
				b7.setLocation(28, 100);
				b7.setSize(19, 19);
				b7.addActionListener(this);
				this.add(b7);
				b8 = new JButton();
				b8.setLocation(76, 100);
				b8.setSize(19, 19);
				b8.addActionListener(this);
				this.add(b8);					

	}
	// Process the button presses
    public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == b1) { // x-1,y-2
			LaserChess.player1.setX(LaserChess.player1.getX() - LaserChess.p1Size);
			LaserChess.player1.setY(LaserChess.player1.getY() - (2 * LaserChess.p1Size));
		} else if (e.getSource() == b2) { // x+1,y-2
			LaserChess.player1.setX(LaserChess.player1.getX() + LaserChess.p1Size);
			LaserChess.player1.setY(LaserChess.player1.getY() - (2 * LaserChess.p1Size));
		} else if (e.getSource() == b3) {// x-2,y-1
			LaserChess.player1.setX(LaserChess.player1.getX() - (2 * LaserChess.p1Size));
			LaserChess.player1.setY(LaserChess.player1.getY() - LaserChess.p1Size);
		} else if (e.getSource() == b4) {// x+2,y-1
			LaserChess.player1.setX(LaserChess.player1.getX() + (2 * LaserChess.p1Size));
			LaserChess.player1.setY(LaserChess.player1.getY() - LaserChess.p1Size);
		} else if (e.getSource() == b5) {// x-2,y+1
			LaserChess.player1.setX(LaserChess.player1.getX() - (2 * LaserChess.p1Size));
			LaserChess.player1.setY(LaserChess.player1.getY() + LaserChess.p1Size);
		} else if (e.getSource() == b6) {// x+2,y+1
			LaserChess.player1.setX(LaserChess.player1.getX() + (2 * LaserChess.p1Size));
			LaserChess.player1.setY(LaserChess.player1.getY() + LaserChess.p1Size);
		} else if (e.getSource() == b7) {// x-1.y+2
			LaserChess.player1.setX(LaserChess.player1.getX() - LaserChess.p1Size);
			LaserChess.player1.setY(LaserChess.player1.getY() + (2 * LaserChess.p1Size));
		} else if (e.getSource() == b8) {// x+1,y+2
			LaserChess.player1.setX(LaserChess.player1.getX() + LaserChess.p1Size);
			LaserChess.player1.setY(LaserChess.player1.getY() + (2 * LaserChess.p1Size));
		} 
		validateXY();
		LaserChess.gameBoard.repaint();
	}

	


	public void validateXY() {
		if (LaserChess.player1.getX() < 0) {// hit left wall
			LaserChess.player1.setX(0);
			LaserChess.player1.hitWall();
			LaserChess.playerOne = LaserChess.player1.getImage();
		}
		if (LaserChess.player1.getX() > 476) {
			LaserChess.player1.setX(476);
			LaserChess.player1.hitWall();
			LaserChess.playerOne = LaserChess.player1.getImage();
		}
		if (LaserChess.player1.getY() > 476) {
			LaserChess.player1.setY(476);
			LaserChess.player1.hitWall();
			LaserChess.playerOne = LaserChess.player1.getImage();
		} else if (LaserChess.player1.getY() < 0) {
			LaserChess.player1.setY(0);
			LaserChess.player1.hitWall();
			LaserChess.playerOne = LaserChess.player1.getImage();
		}
	}

}
