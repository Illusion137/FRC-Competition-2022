package nerds;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import nerds.utils.Constants;

//PUT IN ROBOT.JAVA
public class Autonomous {
    
    public static int waitTimeMS = 250;

    private static final Timer shootTimer = new Timer();
    private static final Timer driveTimer = new Timer();

    public static void autonomous_startup() {
        waitTimeMS = (int)SmartDashboard.getNumber("Autonomous drive delay", 250);
        shootTimer.reset();
        driveTimer.reset();
        //Intakeout
        shootBall();

        //DriveBack
        scheduleDrive();
    }

    public static void shootBall() {
        shootTimer.start();
        while(!shootTimer.hasElapsed(0.1)) {
            System.out.println("Spitting Out");
            Constants.intake_.toggleIntake(true);
        }
    }

    public static void driveBack() {
        driveTimer.start();
        while(!driveTimer.hasElapsed(2)) {
            System.out.println("Driving");
            Constants.driveTrain_.m_drive.arcadeDrive(0, 0.5);
        }
    }

    public static void scheduleDrive() {
        ScheduledExecutorService exexutor = Executors.newSingleThreadScheduledExecutor();
        exexutor.schedule(Autonomous::driveBack, waitTimeMS, TimeUnit.MILLISECONDS);
    }

    public static void AI() {
        //Spin slowly till found ball
        //Center Ball in camera
        //drive forward
        //intake
        //turn back around
        //center to middle
        //drive forwards
        //spit ball out
        /*
         */
    }
    // public static void runForTime(Callable func, long runTime){
    //     long currentTime = System.currentTimeMillis();
    //     long endTime = currentTime+runTime;
    //     while(System.currentTimeMillis() < endTime) {
    //         try{
    //             func.call();
    //         }
    //     }
    // }
}