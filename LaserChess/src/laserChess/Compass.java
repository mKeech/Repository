package laserChess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

// create the compass panel which will show the angle the shot will take.
public class Compass extends JPanel {
	int compassHeight;
    int compassWidth;
	int compassCenter;
	int compassPointerLength;
	int compassCenterDiameter;
	int compassLocationX;
	int compassLocationY;
	private static final long serialVersionUID = 1L;

	public Compass(int compassHeight, int compassWidth, int compassCenter,
			int compassPointerLength, int compassCenterDiameter,
			int compassLocationX, int compassLocationY) {
		this.compassHeight = compassHeight;
		this.compassWidth = compassWidth;
		this.compassCenter = compassCenter;
		this.compassPointerLength = compassPointerLength;
		this.compassCenterDiameter = compassCenterDiameter;
		this.compassLocationX = compassLocationX;
		this.compassLocationY = compassLocationY;
		this.setLayout(null);
		this.setBounds(LaserChess.rightOffSet + LaserChess.shootWidth + 5,
				LaserChess.boardHeight + LaserChess.moveHeight + 15,
				compassWidth, compassHeight);
		this.setDoubleBuffered(true);
		this.setBackground(Color.RED);
		this.setForeground(Color.WHITE);
		ImageIcon compassIcon = new ImageIcon(
				"C:/Users/Marty/workspace/LaserChess/src/images/Compass.png");
		JLabel compassLabel = new JLabel(compassIcon);
		compassLabel.setLayout(null);
		compassLabel.setLocation(0, 0);
		compassLabel.setSize(compassWidth, compassHeight);
		this.add(compassLabel);
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		super.paintComponent(g2d);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, compassWidth,
				compassHeight);
		Ellipse2D.Double circle1 = new Ellipse2D.Double(2, 2, compassWidth - 4,
				compassHeight - 4);
		Ellipse2D.Double circle2 = new Ellipse2D.Double(compassCenter
				- (compassCenterDiameter / 2), compassCenter
				- (compassCenterDiameter / 2), compassCenterDiameter,
				compassCenterDiameter);
		g2d.setPaint(Color.WHITE);
		g2d.fill(circle);
		g2d.setPaint(Color.BLACK);
		g2d.fill(circle1);
		g2d.setPaint(Color.WHITE);
		g2d.fill(circle2);

		int dx, dy, newX, newY;

		double sinx = Math.sin(Math.toRadians(LaserChess.shotAngle));
		double cosx = Math.cos(Math.toRadians(LaserChess.shotAngle));
		dx = (int) (cosx * compassPointerLength);
		dy = (int) (sinx * compassPointerLength);
		newX = compassCenter + dx;
		newY = compassCenter - dy;
		// boundary conditions, newX or newY would be out of bounds
		if ((LaserChess.shotAngle == 0) || (LaserChess.shotAngle == 360)) {
			newX = newX - 1;
		} else if (LaserChess.shotAngle == 180) {
			newX = newX + 1;
		} else if (LaserChess.shotAngle == 90) {
			newY = newY + 1;
		} else if (LaserChess.shotAngle == 270) {
			newY = newY - 1;
		}
		g2d.drawLine(compassCenter, compassCenter, newX, newY);
		g2d.dispose();
	}
}
