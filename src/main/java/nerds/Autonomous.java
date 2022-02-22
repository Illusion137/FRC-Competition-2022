package nerds;

import java.time.chrono.ThaiBuddhistChronology;

import edu.wpi.first.wpilibj.Timer;
import nerds.commands.DriveByDistance;
import nerds.subsytems.DriveTrain;
import nerds.utils.Constants;

public class Autonomous {
    
    private static final Timer timer_ = new Timer();

    public static int stage = 0;

    public static void AI() {
        switch(stage) {
            case 0:
                // Shoot the ball at the start of the match
                rollOutBall();
                break;
            case 1:
                // Back the robot up
                Constants.driveTrain_.m_drive.arcadeDrive(-0.4, 0);
                stage++;
                break;
            case 2:
                // Turn the robot around
                Constants.driveTrain_.m_drive.arcadeDrive(0, 0.5);
                stage++;
                break;
            case 3:
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
