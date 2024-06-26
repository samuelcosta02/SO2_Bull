package bull;

import java.awt.Color;

public class Eye {
	protected Color color;
	protected int width, height;
	
	public Eye(Color color, int width, int height) {
		this.color = color;
		this.width = width;
		this.height = height;
	}

	public void setColor(Color color){
		this.color = color;
	}

	public Color getColor(){
		return color;
	}

	public void drawAt(int x, int y) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillOval(x, y, width, height);
	}
}
