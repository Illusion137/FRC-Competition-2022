package nerds.subsytems;

import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import nerds.commands.JoystickDrive;
import nerds.utils.OIController;

/*Spark is the sparkMax motor controllers on each side of the driveTrain that control the wheels
*Spark Constructor takes in the motors port
*Differential Drive controls both of the motors as well as a few other things
*if we have motorsOnEachSide>1 -> use MotorControllerGroups as parameters for DifferentialDrive constructor
*/
//Note->considering using tankDrive which manually controls both sets of wheels
public class DriveTrain extends SubsystemBase{
    private final MotorController leftBackMotor = new PWMTalonSRX(1); //MotorController Type
    private final MotorController leftFrontMotor = new PWMSparkMax(3); //MotorController Type
    private final MotorController rightbackMotor = new PWMTalonFX(2);//MotorControllerThang
    private final MotorController rightFrontMotor = new PWMSparkMax(4); //MotorController Type

    private final MotorControllerGroup leftMotors = new MotorControllerGroup(leftBackMotor,leftFrontMotor);
    private final MotorControllerGroup rightMotors = new MotorControllerGroup(rightbackMotor,rightFrontMotor);
    private final DifferentialDrive m_drive = new DifferentialDrive(leftBackMotor, rightFrontMotor);

    private double drivetain_internal_get_turn_speed(int degrees){
        
        return 0;
    }

    public DriveTrain(){
        setDefaultCommand(new JoystickDrive(this));
    }
    @Override public void periodic(){}

    public void drivetrain_set_max_drive_speed(double maximumSpeed){ m_drive.setMaxOutput(maximumSpeed); }

    public void drivetrain_stop(){
        m_drive.stopMotor();
    }

    public void drivetrain_command_arcade_drive(){
        System.out.println("drive");
        m_drive.arcadeDrive(OIController.controller.getRightX(), -OIController.controller.getLeftY(), true);
    }
    //*degrees>0=>right :: degrees<0=>left; (degrees >= -180 && degrees <= 180)*/
    /*public void drivetrain_command_movement_turn_by_degrees(double degrees) throws IllegalArgumentException{
        //Else statment is useless but there; due to it will be unreachable code if the if statment is true
        if(degrees >= -180 && degrees <= 180){
            throw new IllegalArgumentException("drivetrain_movement_turn::degrees out of range");
        }else{
            m_drive.tankDrive(-drivetain_internal_get_turn_speed(), drivetain_internal_get_turn_speed());
        }
    }*/

    public void drivetain_auto_movement_drive(double speed, double rotation){
        //m_drive.arcadeDrive(speed, rotation, false);
    }
    public void drivetrain_auto_movement_turn_face_object(){}
}