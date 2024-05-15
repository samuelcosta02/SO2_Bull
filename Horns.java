package bull;

import java.awt.Color;

public class Horns {
	private Color color;
	
	public Horns(Color color) {
		this.color = color;
	}
	
	public void drawAt(int x, int y) {
		Drawing.pen().setColor(color);
        Drawing.pen().drawLine(x, y + 20, x - 10, y - 10);
        Drawing.pen().drawLine(x + 35, y + 20, x + 40, y - 10);
    }
}
