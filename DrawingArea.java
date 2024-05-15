package bull;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingArea extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private final Color COLOR = Color.BLACK;
	private final int WIDTH = 500;
	private final int HEIGHT = 300;
	private final int X = 700;
	private final int Y = 500;

	protected void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		Drawing.set(pen);
		
		Bull bull = new Bull(COLOR, WIDTH, HEIGHT);
		bull.drawAt(X, Y);
	}
}