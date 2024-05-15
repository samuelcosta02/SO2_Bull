package bull;

import java.awt.Color;

public class Nipples {
	private int count, width, height;
	
	public Nipples(int count, int width, int height) {
		this.count = count;
		this.width = width;
		this.height = height;
	}
	
	public void drawAt(int x, int y) {
		Drawing.pen().setColor(Color.PINK);
		for (int i = 0, j = 0; i < count; i++, j = j + width / 15) {
			Drawing.pen().fillOval(x + j, y, width / 20, height / 5);
		}
	}
}
