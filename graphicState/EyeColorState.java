package bull.graphicState;

import bull.Scene;

public class EyeColorState extends State {

    private static EyeColorState instance;

    private EyeColorState(Scene context) {
        this.context = context;
        eyeColor = this ;
    }

    public static EyeColorState getInstance(Scene context) {
        if ( instance == null ) {
            instance = new EyeColorState(context);
        }
        return instance ;
    }

    @Override
    public State changeEyeColor(){
        context.createBulls(context.getBInfo());
        context.changeEyeColor();
        return this;
    }

    @Override
    public State changePosture(){
        context.createBulls(context.getBInfo());
        context.changePosture();
        return PostureState.getInstance(context);
    }
}

