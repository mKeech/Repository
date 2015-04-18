package laserChess;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

// The "frame" JFRAME holds everything
// totalGUI panel inside frame = 500 wide by 600 high at 0.0
// board panel inside totalGUI = 500 wide by 500 high
/*
 *   --------------------------------------------------------------
 *   -  Jframe - "frame"                                          -
 *   - 
 */

public class LaserChess implements ActionListener  {

	// Definition of global values and items that are part of the GUI.

	 static int frameWidth = 510;
	 static int frameHeight = 723;
	 static int boardWidth = 500;
	 static int boardHeight = 500;
	 static int buttonsHeight = 123;
	 static int buttonsWidth = 123;
	 static int compassHeight = 123;
	 static int compassWidth = 123;
	 static int compassCenter = 61;
	 static int compassPointerLength = 45;
	 static int compassCenterDiameter = 10;
	 static int compassLocationX = 0;
	 static int compassLocationY = 0;
	 static int rightOffSet = 200;
	 static int angleWidth = 40;
	 static int angleHeight = 25;
	 static int moveHeight = 25;
	 static int moveWidth = 123;
	 static int shootHeight = 25;
	 static int shootWidth = 80;
	 static int shootSliderHeight = 123;
	 static int shootSliderWidth = 80;
	 static int sBHeight = 123;
	 static int sBWidth = 50;	
	 static int initX = 45;
	 static int initY = 450;
	 static int p1Size = 24;
	 static int shotAngle = 0;

	public static Point p1Center;
	public static BufferedImage playerOne;
	public static BufferedImage playerTwo;
	public static BufferedImage moveImage;
	public static ArrayList<Point> beamPoints;
	public static Font font = new Font("Serif", Font.BOLD, 16);

	static LaserBeam laserBeam;
	JPanel guiPanel;
	static JPanel gameBoard;
	JPanel shotAnglePanel;
	JPanel compass;
	JPanel moveButtonsPanel;
	JPanel shootButtonPanel;
	MovePanel movePanel;
	JTextField angleDisplay;
	// move buttons
	JButton  shootButton;
	JLabel  moveLabel, shootLabel, compassLabel, sBLabel;
	static Player player1, player2;
    JSlider angleSlider;

	public JPanel createContentPane() {
		beamPoints = new ArrayList<Point>();
		player1 = new Player(initX, initY);
		// We create a bottom JPanel to place everything on.
		guiPanel = new GuiPanel();
		
		// creation of the compass panel
		compass = new Compass(compassHeight, compassWidth, compassCenter,
				compassPointerLength, compassCenterDiameter, compassLocationX,
				compassLocationY);		
		guiPanel.add(compass);

		// Creation of the play board
		gameBoard = new GameBoard();
		guiPanel.add(gameBoard);
		
		try {
			playerOne = ImageIO
					.read(new File(
							"./images/smilingStar0.png"));
			playerTwo = ImageIO
					.read(new File(
							"./images/star1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// creation of the move panel to hold the "Move" instruction	
		movePanel = new MovePanel();		
		moveLabel = new MoveLabel();
		movePanel.add(moveLabel);
		guiPanel.add(movePanel);
		// creation of the Shot Angle panel to hold the "Shot Angle" instruction
		shotAnglePanel = new ShotAnglePanel();		
		shootLabel = new ShootLabel();		
		shotAnglePanel.add(shootLabel);
		guiPanel.add(shotAnglePanel);

		// creation of the buttons panel to hold the buttons
		
		moveButtonsPanel = new MoveButtonsPanel();
		guiPanel.add(moveButtonsPanel);
		
		
		
		// creation of the angle slider, 0 to 360
		angleSlider = new AngleSlider(JSlider.VERTICAL, 0, 360, 0);	
		guiPanel.add(angleSlider);
		// add a text field showing the angle to fire
		angleDisplay = new AngleDisplay(3);
		angleDisplay.addActionListener(this);
		guiPanel.add(angleDisplay);

		// creation of the Shoot Button panel to hold the "Shoot" button
		shootButtonPanel = new ShootButtonPanel();
		guiPanel.add(shootButtonPanel);

		
	
		ChangeListener changeListener = new ChangeListener() {
		@Override
		public void stateChanged(ChangeEvent e) {
			AngleSlider  source = (AngleSlider) e.getSource();
			int slangle = (int) source.getValue();
			LaserChess.shotAngle = slangle;
            angleSlider.setValue(slangle);
            angleSlider.repaint();
			angleDisplay.setText(String.valueOf(slangle));			
			angleDisplay.repaint();
			compass.repaint();
		}
		};
		
		guiPanel.addMouseWheelListener(mWListener);
		gameBoard.repaint();
		guiPanel.setOpaque(true);
		guiPanel.repaint();
		return guiPanel;
	}

	MouseWheelListener mWListener = new MouseWheelListener() {

		public void mouseWheelMoved(MouseWheelEvent e) {
			
			int notches = e.getWheelRotation();
			if (notches < 0) {
				shotAngle++;

			} else {
				shotAngle--;
			}
			if (shotAngle < 0) {
				shotAngle = 0;
			} else if (shotAngle > 360) {
				shotAngle = 360;
			}
			angleSlider.setValue(shotAngle);
			angleSlider.repaint();
			angleDisplay.setText(String.valueOf(shotAngle));
			angleDisplay.repaint();
			compass.repaint();
		}
	};

	private static void createAndShowGUI() {

		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame gameFrame = new JFrame("Laser Chess!");
		// Create and set up the content pane.
		LaserChess laserChess = new LaserChess();
		gameFrame.setContentPane(laserChess.createContentPane());
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(520, 750);
		gameFrame.setResizable(false);
		gameFrame.setVisible(true);
	}


	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}