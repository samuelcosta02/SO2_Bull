package bull;

import java.awt.Color;

public class BackLeg extends Leg {
    
    public BackLeg(Color color, int width, int height) {
        super(color, width, height);
    }
    
    public void drawAt(int x, int y) {
        Drawing.pen().setColor(color);
        Drawing.pen().fillRect(x, y, width, height);
    }
}