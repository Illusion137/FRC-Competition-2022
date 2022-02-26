package nerds;

import edu.wpi.first.wpilibj.Timer;
import nerds.utils.Constants;

//PUT IN ROBOT.JAVA
public class Autonomous {
    
    private static final Timer autoTimer = new Timer();

    public static int distance = 0;

    public static void init() throws InterruptedException {
        //Intakeout
        long time= System.currentTimeMillis();
        long end = time+250;
        while(System.currentTimeMillis() < end) {
            Constants.intake_.toggleIntake(true);
            Thread.sleep( 20 );
        }
        //DriveBack
        time= System.currentTimeMillis();
        end = time+1000;
        while(System.currentTimeMillis() < end) {
            Constants.driveTrain_.m_drive.tankDrive(-0.4, 0.4);
            Thread.sleep( 20 );
        }
    }
    private static boolean isStarted = false;
    public static void initPeriodic(){
        if (!isStarted){
            autoTimer.start();
            isStarted = true;
        }
        if(autoTimer.get() < 0.25){
            Constants.intake_.toggleIntake(true);
        }
        else if(autoTimer.get() < 1){
            Constants.driveTrain_.m_drive.tankDrive(-0.4, 0.4);
        }
        else{
            autoTimer.stop();
        }
    }
    // public static void AI() {
    //     System.out.println(stage);
    //     switch(stage) {
    //         case 0:
    //             // Shoot the ball at the start of the match
    //             rollOutBall();
    //             break;
    //         case 1:
    //             // Back the robot up
    //             timer_.start();
    //             System.out.println(timer_.get());
    //             System.out.println("l:" + Constants.driveTrain_.leftMotors.get() + " r:" + Constants.driveTrain_.rightMotors.get());
    //             // If it has been half a second, go to next stage, else drive the robot
    //             if (timer_.hasElapsed(5)) {
    //                 stage = -1;
    //             } else {
    //                 System.out.println("i should be driving right now");
    //                 Constants.driveTrain_.m_drive.tankDrive(-0.4, -0.4);
    //             }
    //             break;
    //     }
    // }

    // public static void rollOutBall(){
    //     timer_.start();
    //     OIController.controller.setRumble(RumbleType.kLeftRumble, 1);
    //     if (timer_.hasElapsed(0.25)) {
    //         stage++;
    //     } else {
    //         Constants.intake_.toggleIntake(true);
    //     }
    // }
}
