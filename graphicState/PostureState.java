package bull.graphicState;

import bull.Scene;

public class PostureState extends State {

    private static PostureState instance;

    private PostureState(Scene context) {
        this . context = context;
        position = this ;
    }

    public static PostureState getInstance(Scene context) {
        if ( instance == null ) {
            instance = new PostureState(context);
        }
        return instance ;
    }

    @Override
    public State changePosture(){
        context.createBulls(context.getBInfo());
        context.changePosture();
        return this ;
    }

    @Override
    public State changeEyeColor(){
        context.createBulls(context.getBInfo());
        context.changeEyeColor();
        return EyeColorState.getInstance(context) ;
    }
}

