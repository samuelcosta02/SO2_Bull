package bull;
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

	public void resetPosition() {
		this.position = 0;
	}

	public void changePosition (int p){
		this.position = p;
		if (p == 1){
			this.width = this.width * 10;
			this.height = this.height / 5;
		} else if (p == 0) {
			this.width = this.width / 10;
			this.height = this.height * 5;
		}

	}
	public void drawAt(int x, int y) {
		Drawing.pen().setColor(color);
		Drawing.pen().fillRect(x, y, width, height);
	}

}
