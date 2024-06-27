package bull.graphicState;

import bull.Scene;

public class HeadOnly extends State {

    private static HeadOnly instance;

    private HeadOnly(Scene context) {
        this.context = context;
        headOnly = this;
    }

    public static HeadOnly getInstance(Scene context) {
        if (instance == null) {
            instance = new HeadOnly(context);
        }
        return instance;
    }

    @Override
    public State fullBull() {
        context.drawFull();
        return FullBull.getInstance(context);
    }

    @Override
    public State headOnly() {
        context.drawHead();
        return this;
    }
}
