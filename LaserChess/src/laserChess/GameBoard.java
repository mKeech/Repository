package laserChess;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JPanel;


public class GameBoard extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public GameBoard() {
			this.setLayout(null);
			this.setBounds(5, 5, LaserChess.boardWidth, LaserChess.boardHeight);
			this.setBackground(Color.BLACK);
			this.setDoubleBuffered(true);
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			drawGameBoard(g);
		}

		private void drawGameBoard(Graphics g) { // draw the player and the shot if 
											// it exists
			Graphics2D g2d = (Graphics2D) g;
			Point p1, p2;
			int x1, x2, y1, y2, size;
			g2d.setColor(new Color(255,255,255));
			g2d.drawImage(LaserChess.playerOne, LaserChess.player1.getX(), LaserChess.player1.getY(), this);
			Toolkit.getDefaultToolkit().sync();
			if ((!(LaserChess.laserBeam == null))
					&& (LaserChess.laserBeam.beamPoints.isEmpty() == false)) {
				size = LaserChess.laserBeam.beamPoints.size()-1;
				// draw the line segments
				for (int i = 0; i < size; i++) {
					p1 = LaserChess.laserBeam.beamPoints.get(i);
					p2 = LaserChess.laserBeam.beamPoints.get(i + 1);
					x1 = p1.x;
					y1 = p1.y;
					x2 = p2.x;
					y2 = p2.y;
					g2d.drawLine(x1, y1, x2, y2);			
				}
				LaserChess.laserBeam.beamPoints.clear();
			}
			g.dispose();
		}
	}
