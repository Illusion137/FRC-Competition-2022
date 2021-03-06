package nerds.commands;

import nerds.subsytems.DriveTrain;
import nerds.utils.OIController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class JoystickDrive extends CommandBase{
    private DriveTrain m_drive;//=> Subsystem of Command

    //Why do constructors have to be public >:(
    public JoystickDrive(DriveTrain _drive){
        m_drive = _drive;
        addRequirements(m_drive);
    }

    @Override public void initialize(){}

    @Override public void execute(){
        m_drive.arcade_drive();
    }
    @Override public void end(boolean interupted){}
    @Override public boolean isFinished() {
        return false;
    }
}