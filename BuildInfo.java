package bull;

import java.awt.*;

public class BuildInfo {
    private Color color;
    private int width;
    private int height;
    private int x;
    private int y;

    public BuildInfo(Color color, int width, int height, int x, int y) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
