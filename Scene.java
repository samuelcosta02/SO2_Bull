package bull;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Point;

public class Scene {
    private ArrayList<Bull> bulls = new ArrayList<Bull>();
    private final int BULLSNUMBER = 4;

    public Scene(Color color, int width, int height, int x, int y) {

        for (int i = 0; i < BULLSNUMBER; i++) {
            addBull(color, RandomNumber.between(width-20, width+100), RandomNumber.between(height-20,height+100), RandomNumber.between(0,x), RandomNumber.between(0,y));
        }

    }

    public void addBull(Color color, int width, int height, int x, int y){
        Point coordinates = new Point(x,y);
        Bull newBull = new Bull(color, width, height, coordinates);

        if ( vacantSpace(newBull) ) {
            bulls.add(newBull);
        }
    }

    public void postureButton(){
        for (Bull bull : bulls) {
            bull.changePosture();
        }
    }

    public void eyeColorButton(){
        for (Bull bull : bulls) {
            Head bullHead = bull.getHead();
            if (bullHead.getEyeColor() == Color.WHITE) {
                bullHead.changeEyeColor(Color.BLUE);
            } else if(bullHead.getEyeColor() == Color.BLUE) {
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
    
    public void draw() {
    	for (Bull bull : bulls) {
            bull.drawAt(bull.address().x, bull.address().y);
        }
    }

}