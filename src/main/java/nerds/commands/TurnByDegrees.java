package nerds.commands;

import nerds.subsytems.DriveTrain;

import edu.wpi.first.wpilibj2.command.CommandBase;
/*Kinda confused on why we need to convert the subsystem into a command
*instead of using the functions in the subsystem as a command direcly
*I feel like these command files are useless*/
public class TurnByDegrees extends CommandBase{
    private final DriveTrain m_driveTrain;
    private double m_degrees = 0;
    private boolean isTurningVar = false;

    public boolean turn_by_degrees_get_isTurning(){ return isTurningVar; }

    public TurnByDegrees(float degrees, DriveTrain _driveTrain){
        m_driveTrain = _driveTrain; 
        m_degrees = degrees;
        addRequirements(m_driveTrain); 
    }

    @Override
    public void initialize() {
        m_driveTrain.drivetrain_command_movement_turn_by_degrees(m_degrees);
    }
    @Override
    public void execute() {
        
    }
}
