package bull;

import java.awt.Color;
import java.awt.Point;

public class Bull implements LocatedRectangle {
	private Color color;
	private Point location;
	private int width, height;
	private Torso torso;			// composite
	private Head head;				// composite
	private Tail tail;				// composite
	private Leg legBack, legFront;	// composite

	public Bull(Color color, int width, int height, Point location) {
		this.color = color;
		this.width = width;
		this.height = height;
		this.location = location;
		this.torso = new Torso(color, width, height);
		this.head = new Head(color, width / 4, height / 2);
		this.tail = new Tail(color, width /4, height / 4);
		this.legBack = new BackLeg(color, width / 20, height / 2);
		this.legFront = new FrontLeg(color, width / 20, height / 2);
	}

	public void drawAt(int x, int y) {
		torso.drawAt(x, y);
		head.drawAt(x + width, y - height / 3);
		tail.drawAt(x, y + height / 5);
		legBack.drawAt(x + width / 20, y + height);
		legFront.drawAt(x + width - width / 10, y + height);
	}

	public Point address () {
		return new Point(location.x, location.y);
	}
	public int width(){
		return width;
	}
	public int height (){
		return height ;
	}
	public void draw(){
		drawAt(location.x, location.y);
	}
}