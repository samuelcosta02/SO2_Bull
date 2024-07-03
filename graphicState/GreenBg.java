package bull.graphicState;

import bull.Scene;

import java.awt.*;

public class GreenBg extends State {

    private static GreenBg instance;

    private GreenBg(Scene context) {
        this.context = context;
        greenBg = this;
    }

    public static GreenBg getInstance(Scene context) {
        if (instance == null) {
            instance = new GreenBg(context);
        }
        return instance;
    }

    @Override
    public State fullBull() {
        context.setBg(Color.WHITE);
        return FullBull.getInstance(context);
    }

    @Override
    public State headOnly() {
        context.setBg(Color.WHITE);
        return HeadOnly.getInstance(context);
    }

    @Override
    public State greenBg() {
        context.setBg(Color.GREEN);
        return this;
    }

}
