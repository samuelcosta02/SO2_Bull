package bull;

import bull.graphicState.PostureState;
import bull.graphicState.State;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Point;


public class Scene {
    private ArrayList<Bull> bulls = new ArrayList<Bull>();
    private final int BULLSNUMBER = 5;
    private static State graphicState;
    private BuildInfo bInfo;

    public Scene(Color color, int width, int height, int x, int y) {
        bInfo = new BuildInfo(color, width, height, x, y);
        for (int i = 0; i < BULLSNUMBER; i++) {
            addBull(color, RandomNumber.between(width-20, width+100), RandomNumber.between(height-20,height+100), RandomNumber.between(0,x), RandomNumber.between(0,y));
        }
        graphicState = PostureState.getInstance(this);
    }

    public void createBulls(BuildInfo bInfo){
        bulls.clear();
        for (int i = 0; i < BULLSNUMBER; i++) {
            addBull(bInfo.getColor(), RandomNumber.between(bInfo.getWidth()-20, bInfo.getWidth()+100), RandomNumber.between(bInfo.getHeight()-20,bInfo.getHeight()+100), RandomNumber.between(0,bInfo.getX()), RandomNumber.between(0,bInfo.getY()));
        }
    }

    public boolean addBull(Color color, int width, int height, int x, int y){
        Point coordinates = new Point(x,y);
        Bull newBull = new Bull(color, width, height, coordinates);

        if ( vacantSpace(newBull) ) {
            bulls.add(newBull);
            return true;
        } else {return false;}
    }

    public void setPostureState(){
        graphicState = graphicState.changePosture();
    }

    public void setEyeColorState(){
        graphicState = graphicState.changeEyeColor();
    }

    public void changePosture(){
        for (Bull bull : bulls) {
            bull.changePosture();
        }
    }

    public void resetPosture(){
        for (Bull bull : bulls) {
            bull.changePosture();
        }
    }

    public void postureButton(){
        setPostureState();
    }


    public void changeEyeColor(){
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
    public void eyeColorButton(){
        setEyeColorState();
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

    public BuildInfo getBInfo() {
        return bInfo;
    }
}