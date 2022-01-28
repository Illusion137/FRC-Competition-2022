package nerds.subsytems;

import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/*Spark is the sparkMax motor controllers on each side of the driveTrain that control the wheels
*Spark Constructor takes in the motors port
*Differential Drive controls both of the motors as well as a few other things
*if we have motorsOnEachSide>1 -> use MotorControllerGroups as parameters for DifferentialDrive constructor
*/
//Note->considering using tankDrive which manually controls both sets of wheels
public class DriveTrain extends SubsystemBase{
    private MotorController leftMotor = new Spark(1); //MotorController Type
    private MotorController rightMotor = new Spark(2); //We prolly using Spark-Maxes idk :/
    private DifferentialDrive m_drive = new DifferentialDrive(leftMotor, rightMotor);

    private double drivetain_internal_get_turn_speed_left(){return 0;}
    private double drivetain_internal_get_turn_speed_right(){return 0;}

    public void periodic(){}

    public void drivetrain_set_max_drive_speed(double maximumSpeed){ m_drive.setMaxOutput(maximumSpeed); }

    public void drivetrain_command_arcade_drive(double speed, double rotation, boolean smoothMovement){
        m_drive.arcadeDrive(speed, rotation, smoothMovement);
    }
    //*degrees>0=>right :: degrees<0=>left; (degrees >= -180 && degrees <= 180)*/
    public void drivetrain_command_movement_turn_by_degrees(double degrees) throws IllegalArgumentException{
        //Else statment is useless but there; due to it will be unreachable code if the if statment is true
        if(degrees >= -180 && degrees <= 180){
            throw new IllegalArgumentException("drivetrain_movement_turn::degrees out of range");
        }else{
            m_drive.tankDrive(drivetain_internal_get_turn_speed_left(), drivetain_internal_get_turn_speed_right());
        }
    }

    public void drivetain_auto_movement_drive(double speed, double rotation){
        m_drive.arcadeDrive(speed, rotation, false);
    }
    public void drivetrain_auto_movement_turn_face_object(){}
}