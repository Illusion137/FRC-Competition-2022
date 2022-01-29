package nerds.commands;

import nerds.subsytems.DriveTrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class JoystickDrive extends CommandBase{
    private final DriveTrain m_drive;//=> Subsystem of Command

    //Why do constructors have to be public >:(
    public JoystickDrive(DriveTrain _drive){
        m_drive = _drive;
        addRequirements(m_drive);
    }
    
    public void joystickdrive_drive(){
        System.out.println("Driving");
    }

    @Override public void initialize(){
        System.out.println("jsDriveINIT");
    }
    @Override public void execute(){
        m_drive.drivetrain_command_arcade_drive();
    }
    @Override public void end(boolean interupted){
        m_drive.drivetrain_stop();
    }
    @Override public boolean isFinished() {
        return false;
    }
}