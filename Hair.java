package bull;

import java.awt.Color;

public class Hair {
	private Color color;
	private int width, height;
	
	public Hair(Color color, int width, int height) {
		this.color = color;
		this.width = width;
		this.height = height;
	}
	
	public void drawAt(int x, int y) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillOval(x, y, width, height);
	}

}
