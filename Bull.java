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
		this.torso = new Torso(color, width / 2, height / 2);
		this.head = new Head(color, (width / 4) / 2, (height / 2) / 2);
		this.tail = new Tail(color, (width /4) / 2, (height / 4) / 2);
		this.legBack = new BackLeg(color, (width / 20) / 2, (height / 2) / 2);
		this.legFront = new FrontLeg(color, (width / 20) / 2, (height / 2) / 2);
	}

	public void drawAt(int x, int y) {
		torso.drawAt(x, y);
		head.drawAt(x + (width / 2), y - (height / 3) /2);
		tail.drawAt(x, y + (height / 5) / 2);
		if (legBack.getPosition() == 0 && legFront.getPosition() == 0) {
			legBack.drawAt(x + (width / 20) / 2, y + (height / 2));
			legFront.drawAt(x + (width / 2) - ((width / 10) / 2), y + (height / 2));
		}
		if (legBack.getPosition() == 1 && legFront.getPosition() == 1) {
			legBack.drawAt(x - (width / 10), y + (height / 2));
			legFront.drawAt(x + (width / 2) - ((width / 10) / 2), y + (height / 2));			
		}
	}

	public boolean intersects (LocatedRectangle other) {
		boolean disjoint =
				other.address() .x + other.width() < this.address().x ||
						other.address().x > this.address().x + this.width() ||
						other.address().y - other.height() > this.address().y;
		return ! disjoint ;
	}

	public void changePosture(){
		if (legBack.getPosition() == 0 && legFront.getPosition() == 0) {
			legBack.changePosition(1);
			legFront.changePosition(1);
		} else if (legBack.getPosition() == 1 && legFront.getPosition() == 1){
			legFront.changePosition(0);
			legBack.changePosition(0);
		}
	}

	public Head getHead(){
		return head;
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