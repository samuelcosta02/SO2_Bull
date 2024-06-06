package bull;

import java.awt.Color;

public class Leg {
	protected Color color;
	protected int width, height;
	
	public Leg(Color color, int width, int height) {
		this.color = color;
		this.width = width;
		this.height = height;
	}
	
	public void drawAt(int x, int y) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillRect(x, y, width, height);
	}

}
