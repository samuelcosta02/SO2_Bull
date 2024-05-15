package bull;

import java.awt.Color;

public class Horn {
	private Color color;
	private int width, height;
	
	public Horn(Color color, int width, int height) {
		this.color = color;
		this.width = width;
		this.height = height;
	}
	public void drawAt(int x, int y) {
		Drawing.pen().setColor(color);
		Drawing.pen().drawLine(x, y, x + width / 2, y - height);
		Drawing.pen().drawLine(x + width / 2, y - height, x + width, y);
	}
}
