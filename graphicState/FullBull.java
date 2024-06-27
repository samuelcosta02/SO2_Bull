package bull.graphicState;

import bull.Scene;

public class FullBull extends State {

    private static FullBull instance;

    private FullBull(Scene context) {
        this.context = context;
        fullBull = this;
    }

    public static FullBull getInstance(Scene context) {
        if (instance == null) {
            instance = new FullBull(context);
        }
        return instance;
    }

    @Override
    public State fullBull() {
        context.drawFull();
        return this;
    }

    @Override
    public State headOnly() {
        context.drawHead();
        return HeadOnly.getInstance(context);
    }

}
