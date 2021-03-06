package nerds;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import nerds.utils.Constants;

//PUT IN ROBOT.JAVA
public class Autonomous {
    
    public static boolean autonomousDisabled = false;
    public static boolean shootDisabled = false;
    public static boolean driveDisabled = false;
    public static int waitTimeMS = 250;
    public static double speed = 0.5;
    public static int driveTimeMS = 4000;

    private static final Timer shootTimer = new Timer();
    private static final Timer driveTimer = new Timer();

    public static void autonomous_startup() {
        autonomousDisabled = SmartDashboard.getBoolean("Auto disabled", false);
        shootDisabled = SmartDashboard.getBoolean("Shoot disabled", false);
        driveDisabled = SmartDashboard.getBoolean("Drive disabled", false);

        waitTimeMS = (int)SmartDashboard.getNumber("Auto delay", 250);
        speed = SmartDashboard.getNumber("Auto speed", 0.5);
        driveTimeMS = (int)SmartDashboard.getNumber("Auto time", 4000);

        shootTimer.reset();
        driveTimer.reset();

        if (!autonomousDisabled) {
            //Intakeout
            shootBall();

            //DriveBack
            scheduleDrive();
        }
        shootTimer.stop();
        driveTimer.stop();
    }

    public static void shootBall() {
        if (!shootDisabled) {
            shootTimer.start();

            while(!shootTimer.hasElapsed(0.1)) {
                Constants.intake_.toggleIntake(true);
            }

            shootTimer.stop();
        }
    }

    public static void driveBack() {
        if (!driveDisabled) {
            shootTimer.stop();
            driveTimer.start();

            while(!driveTimer.hasElapsed(driveTimeMS / 1000D)) {
                Constants.driveTrain_.m_drive.arcadeDrive(0, speed);
            }
            driveTimer.stop();
        }
    }

    public static void scheduleDrive() {
        if (!driveDisabled) {
            ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
            executor.schedule(Autonomous::driveBack, waitTimeMS, TimeUnit.MILLISECONDS);
        }
    }

    // public static void AI() {
    //     //Spin slowly till found ball
    //     //Center Ball in camera
    //     //drive forward
    //     //intake
    //     //turn back around
    //     //center to middle
    //     //drive forwards
    //     //spit ball out
    //     /*
    //      */
    // }
}