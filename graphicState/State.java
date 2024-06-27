package bull.graphicState;

import bull.Scene;

public abstract class State {

    protected Scene context;

    protected static FullBull fullBull;
    protected static HeadOnly headOnly;

    public abstract State fullBull();
    public abstract State headOnly();

}
