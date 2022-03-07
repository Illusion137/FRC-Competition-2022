package nerds.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import nerds.subsytems.IntakePistons;
import nerds.utils.OIController;

public class ToggleIntakePistons extends CommandBase{
    private IntakePistons m_intakePistons;
    private boolean hasPressed = false;

    public ToggleIntakePistons(IntakePistons _intakePistons){
        m_intakePistons = _intakePistons;
        addRequirements(_intakePistons);
    }

    @Override public void initialize(){}
    @Override public void execute(){
        if(OIController.yButton.get()){
            if (!hasPressed) {
                m_intakePistons.togglePistons();
                hasPressed = true;
            }
        } else {
            hasPressed = false;
        }
    }
    @Override public void end(boolean interupted){}
    @Override public boolean isFinished() {return false; }
}
