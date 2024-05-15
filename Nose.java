package bull;

import java.awt.Color;

public class Nose {
	private Color color;
	private int width, height;
	
	public Nose(Color color, int width, int height) {
		this.color = color;
		this.width = width;
		this.height = height;
	}
	
	public void drawAt(int x, int y) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillOval(x, y, width, height);
	}
}
