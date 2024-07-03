package bull.graphicState;

import bull.Scene;

public abstract class State {

    protected Scene context;

    protected static FullBull fullBull;
    protected static HeadOnly headOnly;
    protected static GreenBg greenBg;

    public abstract State fullBull();
    public abstract State headOnly();
    public abstract State greenBg();

}
