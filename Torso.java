package bull;

import java.awt.Color;

public class Torso {
	private Color color;
	private int width, height;
	private Nipples nipples; // composite
	
	public Torso(Color color, int width, int height) {
		this.color = color;
		this.width = width;
		this.height = height;
		this.nipples = new Nipples(3, width, height);	// composite
	}
	
	public void drawAt(int x, int y) {
        Drawing.pen().setColor(color);
        Drawing.pen().fillRect(x, y, width, height);
        nipples.drawAt(x + width / 3, y + height - height / 10);
    }
}
