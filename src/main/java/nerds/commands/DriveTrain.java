package nerds.commands;
import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

/*Spark is the sparkMax motor controllers on each side of the driveTrain that control the wheels
*Spark Constructor takes in the motors port
*Differential Drive controls both of the motors as well as a few other things
*if we have motorsOnEachSide>1 -> use MotorControllerGroups as parameters for DifferentialDrive constructor
*/
//Note->considering using tankDrive which manually controls both sets of wheels
public class DriveTrain extends SubsystemBase{
    private static Spark leftMotor = new Spark(0);
    private static Spark rightMotor = new Spark(1);
    private static DifferentialDrive m_drive = new DifferentialDrive(leftMotor, rightMotor);

    public static void drivetrain_set_max_drive_speed(double maximumSpeed){
        m_drive.setMaxOutput(maximumSpeed);
    }
    public static void drivetrain_command_movement_drive(double speed, double rotation, boolean smoothMovement){
        m_drive.arcadeDrive(speed, rotation, smoothMovement);
    }
    //*degrees>0=>right :: degrees<0=>left; (degrees >= -180 && degrees <= 180)*/
    public static void drivetrain_command_movement_turn_by_degrees(double speed, int degrees) throws Exception{
        //Else statment is useless due to it will be unreachable code if the if statment is true
        if(degrees >= -180 && degrees <= 180){throw new Exception("drivetrain_movement_turn::degrees out of range");}else{
            //m_drive.tankDrive(leftSpeed, rightSpeed);
        }
    }
    public static void drivetain_auto_movement_drive(double speed, double rotation){
        m_drive.arcadeDrive(speed, rotation, false);
    }
}