package nerds.subsytems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import nerds.commands.JoystickDrive;
import nerds.utils.Constants;
import nerds.utils.DelayUtil;
import nerds.utils.OIController;

/*Spark is the sparkMax motor controllers on each side of the driveTrain that control the wheels
*Spark Constructor takes in the motors port
*Differential Drive controls both of the motors as well as a few other things
*if we have motorsOnEachSide>1 -> use MotorControllerGroups as parameters for DifferentialDrive constructor
*/
public class DriveTrain extends SubsystemBase{ 
    public final CANSparkMax leftBackMotor = new CANSparkMax(Constants.LEFTBACKMOTORPORT, MotorType.kBrushless); //MotorController Type
    public final CANSparkMax leftFrontMotor = new CANSparkMax(Constants.LEFTFRONTKMOTORPORT, MotorType.kBrushless); //MotorController Type
    public final CANSparkMax rightBackMotor = new CANSparkMax(Constants.RIGHTBACKMOTORPORT, MotorType.kBrushless);//MotorControllerThang
    public final CANSparkMax rightFrontMotor = new CANSparkMax(Constants.RIGHTFRONTMOTORPORT, MotorType.kBrushless); //MotorController Type

    public final MotorControllerGroup leftMotors = new MotorControllerGroup(leftBackMotor,leftFrontMotor);
    public final MotorControllerGroup rightMotors = new MotorControllerGroup(rightBackMotor,rightFrontMotor);
    public final DifferentialDrive m_drive = new DifferentialDrive(leftMotors, rightMotors);

    private final DelayUtil delay = new DelayUtil();

    public double rampRate = 0.5;
    
    public DriveTrain(){
        setDefaultCommand(new JoystickDrive(this));
    }

    @Override public void periodic(){}

    public void set_max_drive_speed(double maximumSpeed){ 
        m_drive.setMaxOutput(maximumSpeed); 
    }

    public boolean leftStickTurn;

    public void arcade_drive(){ 
        leftStickTurn = SmartDashboard.getBoolean("Left stick turn", true);
        rampRate = SmartDashboard.getNumber("Ramp rate", 0.5);
        leftBackMotor.setClosedLoopRampRate(rampRate);
        leftBackMotor.setOpenLoopRampRate(rampRate);
        leftFrontMotor.setClosedLoopRampRate(rampRate);
        leftFrontMotor.setOpenLoopRampRate(rampRate);
        rightBackMotor.setClosedLoopRampRate(rampRate);
        rightBackMotor.setOpenLoopRampRate(rampRate);
        rightFrontMotor.setClosedLoopRampRate(rampRate);
        rightFrontMotor.setOpenLoopRampRate(rampRate);
        m_drive.arcadeDrive(leftStickTurn ? OIController.controller.getLeftX() : OIController.controller.getRightX(), OIController.controller.getLeftY(), true);
    }

    public void drive(double moveSpeed, double turnSpeed) {
        m_drive.arcadeDrive(moveSpeed, turnSpeed);
    }
}