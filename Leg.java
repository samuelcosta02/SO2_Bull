package bull;
//Positions:
// Standing = 0 (default)
// Laying 	= 1
import java.awt.Color;

public class Leg {
	protected Color color;
	protected int width, height;
	protected int position;
	
	public Leg(Color color, int width, int height) {
		this.color = color;
		this.width = width;
		this.height = height;
		this.position = 0;
	}

	public int getPosition(){
		return position;
	}

	public void changePosition (int p){
		this.position = p;
		if (p == 0){
			this.width = this.width - (this.width / 5);
			this.height = this.height + (this.height * 2);
		} if (p == 1) {
			this.width = this.width + (this.width * 5);
			this.height = this.height - (this.height / 2);
		}
	}
	public void drawAt(int x, int y) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillRect(x, y, width, height);
	}

}
