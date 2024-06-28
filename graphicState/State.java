package bull.graphicState;

import bull.Scene;

public abstract class State {

    protected Scene context;

    protected static EyeColorState eyeColor;
    protected static PostureState position ;

    public abstract State changeEyeColor();

    public abstract State changePosture();

}
