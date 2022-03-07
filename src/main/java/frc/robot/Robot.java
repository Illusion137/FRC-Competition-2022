package frc.robot;

import nerds.Autonomous;
import nerds.utils.Constants;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.revrobotics.CANSparkMax.IdleMode;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.shuffleboard.EventImportance;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

	public void robot_oi_config(){
		Constants.driveTrain_.set_max_drive_speed(0.5);
	}

	Thread m_visionThread;
	/**
	 * This function is run when the robot is first started up and should be used for any
	 * initialization code.
	 */
	@Override
	public void robotInit() {
		SmartDashboard.putNumber("Auto delay", Autonomous.waitTimeMS);
		SmartDashboard.putNumber("Auto speed", Autonomous.speed);
		SmartDashboard.putBoolean("Left stick turn", true);
		SmartDashboard.putNumber("Auto time", Autonomous.driveTimeMS);
		SmartDashboard.putNumber("Ramp rate", Constants.driveTrain_.rampRate);

		// Get the UsbCamera from CameraServer
		UsbCamera camera = CameraServer.startAutomaticCapture();
		m_visionThread =
        new Thread(
            () -> {
              
              // Set the resolution
            //   camera.setResolution(640, 480);

              // Get a CvSink. This will capture Mats from the camera
              CvSink cvSink = CameraServer.getVideo();
              // Setup a CvSource. This will send images back to the Dashboard
              CvSource outputStream = CameraServer.putVideo("Rectangle", 640, 480);

              // Mats are very memory expensive. Lets reuse this Mat.
              Mat mat = new Mat();
			  Mat gray = new Mat();
			  Imgproc.cvtColor(mat, gray, Imgproc.COLOR_BGR2GRAY);
			  Imgproc.medianBlur(gray, gray, 5);
			  Mat circles = new Mat();

              // This cannot be 'true'. The program will never exit if it is. This
              // lets the robot stop this thread when restarting robot code or
              // deploying.
              while (!Thread.interrupted()) {
				Imgproc.HoughCircles(gray, circles, Imgproc.HOUGH_GRADIENT, 1.0,
				(double)gray.rows()/16, // change this value to detect circles with different distances to each other
				100.0, 30.0, 1, 30); // change the last two parameters
					// (min_radius & max_radius) to detect larger circles
				for (int x = 0; x < circles.cols(); x++) {
					double[] c = circles.get(0, x);
					Point center = new Point(Math.round(c[0]), Math.round(c[1]));
					// circle center
					Imgproc.circle(mat, center, 1, new Scalar(0,100,100), 3, 8, 0 );
					// circle outline
					int radius = (int) Math.round(c[2]);
					Imgproc.circle(mat, center, radius, new Scalar(255,0,255), 3, 8, 0 );
				}
                // Tell the CvSink to grab a frame from the camera and put it
                // in the source mat.  If there is an error notify the output.
                if (cvSink.grabFrame(mat) == 0) {
                  // Send the output the error.
                  outputStream.notifyError(cvSink.getError());
                  // skip the rest of the current iteration
                  continue;
                }
                // Put a rectangle on the image
                // Imgproc.rectangle(mat, new Point(0, 100), new Point(400, 400), new Scalar(255, 255, 255), Imgproc.FILLED);
                // Give the output stream a new image to display
                outputStream.putFrame(circles);
              }
            });
		m_visionThread.setDaemon(true);
		m_visionThread.start();
		//All above is copy pasta
		Constants.driveTrain_.leftBackMotor.setIdleMode(IdleMode.kCoast);
        Constants.driveTrain_.leftFrontMotor.setIdleMode(IdleMode.kCoast);
        Constants.driveTrain_.rightBackMotor.setIdleMode(IdleMode.kCoast);
        Constants.driveTrain_.rightFrontMotor.setIdleMode(IdleMode.kCoast);
	}

	/**
	 * This function is called every robot packet, no matter the mode. Use this for items like
	 * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
	 *
	 * <p>This runs after the mode specific periodic functions, but before LiveWindow and
	 * SmartDashboard integrated updating.
	 */
	@Override
	public void robotPeriodic() {
		// System.out.println(Constants.intakePistons_.solenoidValves.get());
		CommandScheduler.getInstance()
        .onCommandInitialize(
            command ->
                Shuffleboard.addEventMarker(
                    "Command initialized", command.getName(), EventImportance.kNormal));
		CommandScheduler.getInstance()
			.onCommandInterrupt(
				command ->
					Shuffleboard.addEventMarker(
						"Command interrupted", command.getName(), EventImportance.kNormal));
		CommandScheduler.getInstance()
			.onCommandFinish(
				command ->
					Shuffleboard.addEventMarker(
						"Command finished", command.getName(), EventImportance.kNormal));
		CommandScheduler.getInstance().run();

	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different
	 * autonomous modes using the dashboard. The sendable chooser code works with the Java
	 * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
	 * uncomment the getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to the switch structure
	 * below with additional strings. If using the SendableChooser make sure to add them to the
	 * chooser code above as well.	
	 */
	@Override
	public void autonomousInit() {
		// Autonomous.init();
		onEnable();
		Autonomous.autonomous_startup();
	}

	/** This function is called periodically during autonomous. */
	@Override
	public void autonomousPeriodic() {
		
	}

	/** This function is called once when teleop is enabled. */
	@Override
	public void teleopInit() {
		onEnable();
		robot_oi_config();
	}

	/** This function is called periodically during operator control. */
	@Override
	public void teleopPeriodic() {
	}

	/** This function is called once when the robot is disabled. */
	@Override
	public void disabledInit() {
		
	}

	/** This function is called periodically when disabled. */
	@Override
	public void disabledPeriodic() {
		// Setting this here too just to make sure that it brakes when it is disabled
		// Constants.climber.motor1.setNeutralMode(NeutralMode.Brake);
        // Constants.climber.motor2.setNeutralMode(NeutralMode.Brake);
	}

	/** This function is called once when test mode is enabled. */
	@Override
	public void testInit() {
		onEnable();
	}

	/** This function is called periodically during test mode. */
	@Override
	public void testPeriodic() {}

	// Called when the enable button is pressed
	public void onEnable() {
		Constants.intakePistons_.solenoidValves.set(Value.kReverse);
	}
}