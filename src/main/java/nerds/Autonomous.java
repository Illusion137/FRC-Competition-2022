package nerds;

import edu.wpi.first.wpilibj.Timer;
import nerds.utils.Constants;

public class Autonomous {
    private static final Timer timer_ = new Timer();
    public static void rollOutBall(){
        timer_.start();
        if(timer_.get() < 0.25){
            Constants.intake_.toggleIntake(false);
        }
        timer_.stop();
        timer_.reset();
    }
}
