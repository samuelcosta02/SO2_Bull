package bull.graphicState;

import bull.Scene;

import java.awt.*;

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
        context.setBg(Color.WHITE);
        return this;
    }

    @Override
    public State headOnly() {
        context.setBg(Color.WHITE);
        return HeadOnly.getInstance(context);
    }

    @Override
    public State greenBg() {
        context.setBg(Color.GREEN);
        return GreenBg.getInstance(context);
    }

}
