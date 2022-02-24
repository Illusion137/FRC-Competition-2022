package nerds;

import edu.wpi.first.wpilibj.Timer;
import nerds.utils.Constants;

public class Autonomous {
    
    private static final Timer timer_ = new Timer();

    public static int stage = 0;
    public static int distance = 0;

    public static void AI() {
        switch(stage) {
            case 0:
                // Shoot the ball at the start of the match
                rollOutBall();
                break;
            case 1:
                // Back the robot up
                if (distance < 5) {
                    Constants.driveTrain_.m_drive.arcadeDrive(-0.4, 0);
                    distance++;
                } else {
                    distance = 0;
                    stage++;
                }
                break;
            case 2:
                break;
        }
    }

    public static void rollOutBall(){
        timer_.start();
        if (timer_.get() < 0.25){
            Constants.intake_.toggleIntake(false);
        }
        timer_.reset();
        stage++;
    }
}
