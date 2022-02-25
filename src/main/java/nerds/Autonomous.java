package nerds;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import nerds.utils.Constants;
import nerds.utils.OIController;

public class Autonomous {
    
    private static final Timer timer_ = new Timer();

    public static int stage = 0;
    public static int distance = 0;

    public static void init() {
        stage = 0;
    }

    public static void AI() {
        System.out.println(stage);
        if (Constants.intakePistons_.solenoidValves.get() != Value.kForward) {
            Constants.intakePistons_.solenoidValves.set(Value.kForward);
        }
        switch(stage) {
            case 0:
                // Shoot the ball at the start of the match
                rollOutBall();
                break;
            case 1:
                // Back the robot up
                timer_.start();
                // If it has been half a second, go to next stage, else drive the robot
                if (timer_.hasElapsed(5)) {
                    stage++;
                } else {
                    Constants.driveTrain_.m_drive.arcadeDrive(-0.1, 0);
                }
                break;
            case 2:
                break;
        }
    }

    public static void rollOutBall(){
        timer_.start();
        OIController.controller.setRumble(RumbleType.kLeftRumble, 1);
        if (timer_.hasElapsed(0.25)) {
            stage++;
        } else {
            Constants.intake_.toggleIntake(true);
        }
    }
}
