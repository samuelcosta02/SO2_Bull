package bull;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Point;

public class Scene {
    private ArrayList<Bull> bulls = new ArrayList<Bull>();

    public Scene(Color color, int width, int height, int x, int y){
        addBull(color, width, height, x, y);
        addBull(color, width, height, 300, y);
/*        for (int i = 0; i < 3; i++) {
            addBull(color, width, height, x, y);
        }*/

        for (Bull bull : bulls) {
            bull.drawAt(x, y);
        }

    }

    public void addBull(Color color, int width, int height, int x, int y){
        Point coordenates = new Point(x,y);
        Bull newBull = new Bull(color, width, height, coordenates);

        if ( vacantSpace(newBull) )
            bulls.add(newBull);
    }

    private boolean vacantSpace(Bull newBull) {
        boolean anyIntersection = false ;

        for (Bull h : bulls)
            anyIntersection = anyIntersection || h.intersects (newBull);
        return ! anyIntersection ;
    }
}