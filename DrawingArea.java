package bull;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingArea extends JPanel {
	private static final long serialVersionUID = 1L;

	private final Color COLOR = Color.BLACK;
	private final int WIDTH = 200;
	private final int HEIGHT = 100;
	private final int X = 700;
	private final int Y = 500;

	private final Scene scene = new Scene(COLOR, WIDTH, HEIGHT, X, Y);

	protected void paintComponent(Graphics pen) {
		super.paintComponent(pen);
		Drawing.set(pen);
		scene.draw();
	}

	protected Scene getScene() {
		return scene;
	}
}