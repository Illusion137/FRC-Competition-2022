package nerds;

import edu.wpi.first.wpilibj.Timer;
import nerds.utils.Constants;

//PUT IN ROBOT.JAVA
public class Autonomous {
    
    private static final Timer shootTimer = new Timer();
    private static final Timer driveTimer = new Timer();

    public static int distance = 0;

    private static boolean hasSpatBall = false;

    private static Thread shootBallThread = new Thread(() -> {
        shootTimer.start();
        while(!shootTimer.hasElapsed(0.25)) {
            System.out.println("Spitting Out");
            Constants.intake_.toggleIntake(true);
        }
        hasSpatBall = true;
    });

    private static Thread driveThread = new Thread(() -> {
        driveTimer.start();
        while(!driveTimer.hasElapsed(2) && hasSpatBall) {
            System.out.println("Driving");
            Constants.driveTrain_.m_drive.arcadeDrive(0, 0.5);
        }
    });

    public static void autonomous_startup() {
        //Intakeout
        shootBallThread.run();

        //DriveBack
        driveThread.run();
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