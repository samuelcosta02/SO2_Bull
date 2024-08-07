package bull.graphicState;

import bull.Scene;

import java.awt.*;

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
        context.setBg(Color.WHITE);
        return FullBull.getInstance(context);
    }

    @Override
    public State headOnly() {
        context.setBg(Color.WHITE);
        return this;
    }

    @Override
    public State greenBg() {
        context.setBg(Color.GREEN);
        return GreenBg.getInstance(context);
    }

}
