package nerds;

import java.util.function.Function;

import edu.wpi.first.wpilibj.Timer;
import nerds.utils.Constants;

//PUT IN ROBOT.JAVA
public class Autonomous {
    
    private static final Timer autoTimer = new Timer();

    public static int distance = 0;

    private static Thread shootBallThread = new Thread(() -> {
        long time= System.currentTimeMillis();
        long end = time+250;
        while(System.currentTimeMillis() < end) {
            System.out.println("Spitting Out");
            Constants.intake_.toggleIntake(true);
        }
    });

    private static Thread driveThread = new Thread(() -> {
        long time1= System.currentTimeMillis();
        long end1 = time1+1500;
        while(System.currentTimeMillis() < end1) {
            System.out.println("Driving");
            Constants.driveTrain_.m_drive.arcadeDrive(0, 0.5);
        }
    });

    public static void autonomous_startup() {
        //Intakeout
        shootBallThread.run();

        //DriveBack
        
        try {
            
            driveThread.sleep(250);
        } catch(Exception e) {
            e.printStackTrace();
        }
        driveThread.run();
    }

    public static void AI() {

        // VideoCamera camera = new UsbCamera();



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
    public static void runForTime(Function function, long runTime){
        long currentTime = System.currentTimeMillis();
        long endTime = currentTime+runTime;
        while(System.currentTimeMillis() < endTime) {
            System.out.println("Spitting Out");
            Constants.intake_.toggleIntake(true);
        }
    }
}
