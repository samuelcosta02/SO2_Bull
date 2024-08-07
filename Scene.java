package bull;

import bull.graphicState.FullBull;
import bull.graphicState.HeadOnly;
import bull.graphicState.GreenBg;
import bull.graphicState.State;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Point;

public class Scene {
    private ArrayList<Bull> bulls = new ArrayList<Bull>();
    private final int BULLSNUMBER = 100;
    private static State graphicState;
    private Color backgroundColor = Color.WHITE;
    private int x, y;

    public Scene(Color color, int width, int height, int x, int y) {
        this.x = x;
        this.y = y;
        createBull(color, width, height, x, y);
        graphicState = FullBull.getInstance(this);
    }

    public void createBull(Color color, int width, int height, int x, int y) {
        for (int i = 0; i < BULLSNUMBER; i++) {
            addBull(color, RandomNumber.between(width-20, width+100), RandomNumber.between(height-20,height+100), RandomNumber.between(0,x), RandomNumber.between(0,y));
        }
    }

    public boolean addBull(Color color, int width, int height, int x, int y){
        Point coordinates = new Point(x,y);
        Bull newBull = new Bull(color, width, height, coordinates);

        if ( vacantSpace(newBull) ) {
            bulls.add(newBull);
            return true;
        } else {
            return false;
        }
    }

    public void setBg(Color color) {
        backgroundColor = color;
    }

    public void postureButton() {
        for (Bull bull : bulls) {
            bull.changePosture();
        }
    }

    public void eyeColorButton() {
        for (Bull bull : bulls) {
            Head bullHead = bull.getHead();
            if (bullHead.getEyeColor() == Color.WHITE) {
                bullHead.changeEyeColor(Color.BLUE);
            } else if (bullHead.getEyeColor() == Color.BLUE) {
                bullHead.changeEyeColor(Color.RED);
            } else if (bullHead.getEyeColor() == Color.RED) {
            	bullHead.changeEyeColor(Color.WHITE);
            }
        }
    }

    private boolean vacantSpace(Bull newBull) {
        boolean anyIntersection = false ;

        for (Bull h : bulls)
            anyIntersection = anyIntersection || h.intersects (newBull);
        return ! anyIntersection ;
    }

    public void fullState() {
        graphicState = graphicState.fullBull();
    }

    public void headState() {
        graphicState = graphicState.headOnly();
    }

    public void greenState() {
        graphicState = graphicState.greenBg();
    }

    public void draw() {
        Drawing.pen().setColor(backgroundColor);
        Drawing.pen().fillRect(0, 0, x, y);
        if (graphicState == FullBull.getInstance(this)) {
            drawFull();
        } else if (graphicState == HeadOnly.getInstance(this)) {
            drawHead();
        } else if (graphicState == GreenBg.getInstance(this)) {
            drawFull();
        }
    }

    public void drawFull() {
    	for (Bull bull : bulls) {
            bull.drawAt(bull.address().x, bull.address().y);
        }
    }

    public void drawHead() {
        for (Bull bull : bulls) {
            bull.getHead().drawAt(bull.address().x + (bull.width() / 2), bull.address().y - (bull.height() / 3) / 2);
        }
    }

}