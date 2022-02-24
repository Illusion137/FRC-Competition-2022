package nerds.subsytems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
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
//Note->considering using tankDrive which manually controls both sets of wheels
public class DriveTrain extends SubsystemBase{ 
    private final CANSparkMax leftBackMotor = new CANSparkMax(Constants.LEFTBACKMOTORPORT, MotorType.kBrushless); //MotorController Type
    private final CANSparkMax leftFrontMotor = new CANSparkMax(Constants.LEFTFRONTKMOTORPORT, MotorType.kBrushless); //MotorController Type
    private final CANSparkMax rightbackMotor = new CANSparkMax(Constants.RIGHTBACKMOTORPORT, MotorType.kBrushless);//MotorControllerThang
    private final CANSparkMax rightFrontMotor = new CANSparkMax(Constants.RIGHTFRONTMOTORPORT, MotorType.kBrushless); //MotorController Type

    private final MotorControllerGroup leftMotors = new MotorControllerGroup(leftBackMotor,leftFrontMotor);
    private final MotorControllerGroup rightMotors = new MotorControllerGroup(rightbackMotor,rightFrontMotor);
    public final DifferentialDrive m_drive = new DifferentialDrive(leftMotors, rightMotors);

    private final DelayUtil delay = new DelayUtil();

    public DriveTrain(){
        setDefaultCommand(new JoystickDrive(this));
    }

    @Override public void periodic(){}

    public void set_max_drive_speed(double maximumSpeed){ m_drive.setMaxOutput(maximumSpeed); }

    double slowDown = 0;
    boolean set = false;

    public void smooth_stop() {
        if (!set) {
            slowDown = rightMotors.get();
        }
        if (delay.hasTimeElapsed(75, true)) {
            if (slowDown > 0) {
                slowDown -= 0.01;
                System.out.println(slowDown);
            }
        }
        m_drive.arcadeDrive(slowDown, 0);
    }

    public void arcade_drive(){ m_drive.arcadeDrive(OIController.controller.getLeftX(), OIController.controller.getLeftY(), true);}
    //*degrees>0=>right :: degrees<0=>left; (degrees >= -180 && degrees <= 180)*/
    /*public void command_movement_turn_by_degrees(double degrees) throws IllegalArgumentException{
        //Else statment is useless but there; due to it will be unreachable code if the if statment is true
        if(degrees >= -180 && degrees <= 180){
            throw new IllegalArgumentException("movement_turn::degrees out of range");
        }else{
            m_drive.tankDrive(-drivetain_internal_get_turn_speed(), drivetain_internal_get_turn_speed());
        }
    }*/
    public void movement_drive(double speed, double rotation){
        //m_drive.arcadeDrive(speed, rotation, false);
    }

    public void drive(double moveSpeed, double turnSpeed) {
        m_drive.arcadeDrive(moveSpeed, turnSpeed);
    }

    public void movement_turn_face_object(){}
}