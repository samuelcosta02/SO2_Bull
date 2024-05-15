package bull;

import java.awt.Color;

public class Bull {
	private Color color;
	private int width, height;
	private Torso torso;
	private Head head;
	private Tail tail;
	private Leg legBack, legFront;
	
	public Bull(Color color, int width, int height) {
		this.color = color;
		this.width = width;
		this.height = height;
		this.torso = new Torso(color, width, height);
		this.head = new Head(color, width / 4, height / 2);
		this.tail = new Tail(color, width /4, height / 4);
		this.legBack = new Leg(color, width / 20, height / 2);
		this.legFront = new Leg(color, width / 20, height / 2);
	}
	
	public void drawAt(int x, int y) {
		torso.drawAt(x, y);
		head.drawAt(x + width, y - height / 3);
		tail.drawAt(x, y + height / 5);
		legBack.drawAt(x + width / 20, y + height);
		legFront.drawAt(x + width - width / 10, y + height);
	}
}