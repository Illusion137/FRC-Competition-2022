package frc.robot;

import nerds.Autonomous;
import nerds.utils.Constants;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.cameraserver.CameraServer;
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
		Constants.driveTrain_.set_max_drive_speed(0.7);
	}

	/**
	 * This function is run when the robot is first started up and should be used for any
	 * initialization code.
	 */
	@Override
	public void robotInit() {
		SmartDashboard.putBoolean("Auto disabled", Autonomous.autonomousDisabled);
		SmartDashboard.putBoolean("Shoot disabled", Autonomous.shootDisabled);
		SmartDashboard.putBoolean("Drive disabled", Autonomous.driveDisabled);

		SmartDashboard.putNumber("Auto delay", Autonomous.waitTimeMS);
		SmartDashboard.putNumber("Auto speed", Autonomous.speed);
		SmartDashboard.putBoolean("Left stick turn", true);
		SmartDashboard.putNumber("Auto time", Autonomous.driveTimeMS);
		SmartDashboard.putNumber("Ramp rate", Constants.driveTrain_.rampRate);

		// CameraServer.startAutomaticCapture();
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