package bull;

import java.awt.Color;

public class Tail {
	private Color color;
	private int width, height;
	private Hair hair;
	
	public Tail(Color color, int width, int height) {
		this.color = color;
		this.width = width;
		this.height = height;
		this.hair = new Hair(color, (width * 4) / 16, (height * 4) / 8);	// composite
	}
	public void drawAt(int x, int y) {
		Drawing.pen().setColor(color);
		for (int i = 0; i < height / 5; i++) {
			Drawing.pen().drawLine(x, y - i, x - width, y + height - i);
		}
		hair.drawAt(x - width - width / 10, y + height - height / 3);
	}

}
