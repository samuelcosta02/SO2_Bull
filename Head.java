package bull;

import java.awt.Color;

public class Head {
	private Color color;
	private int width, height;
	private Ear earLeft, earRight; // composite
	private Eye eyeLeft, eyeRight; // composite
	private Nose nose; // composite
	private Mouth mouth; // composite
	private Horn hornLeft, hornRight; // composite
	
	public Head(Color color, int width, int height) {
		this.color = color;
		this.width = width;
		this.height = height;
		this.earLeft = new Ear(color, this.width / 16, this.height / 4);			// composite
		this.earRight = new Ear(color, this.width / 16, this.height / 4);			// composite
		this.eyeLeft = new Eye(Color.WHITE, this.width / 5, this.height / 5);		// composite
		this.eyeRight = new Eye(Color.WHITE, this.width / 5, this.height / 5);		// composite
		this.nose = new Nose(Color.PINK, this.width / 2, this.height / 4);			// composite
		this.mouth = new Mouth(Color.PINK, this.width / 2, this.height / 20);		// composite
		this.hornLeft = new Horn(Color.BLACK, this.width / 5, this.height / 2);		// composite
		this.hornRight = new Horn(Color.BLACK, this.width / 5, this.height / 2);	// composite
	}
	
	public void drawAt(int x, int y) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillRect(x, y, width, height);
		earLeft.drawAt(x, y - height / 4);
		earRight.drawAt(x + width - width / 25, y - height / 4);
		eyeLeft.drawAt(x + width / 4, y + height / 5);
		eyeRight.drawAt(x + width / 2 + width / 15, y + height / 5);
		nose.drawAt(x + width / 4, y + height / 2);
		mouth.drawAt(x + width / 4, y + height / 2 + height / 3);
		hornLeft.drawAt(x + width / 4, y);
		hornRight.drawAt(x + width / 2 + width / 15, y);
	}
}