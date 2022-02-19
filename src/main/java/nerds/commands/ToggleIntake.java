package nerds.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import nerds.subsytems.Intake;
import nerds.utils.OIController;

public class ToggleIntake extends CommandBase{
    private Intake m_intake;
    public ToggleIntake(Intake _intake){
        m_intake = _intake;
        addRequirements(m_intake);
    }

    @Override public void initialize(){}
    @Override public void execute(){
        if(OIController.rBButton.get()){
            m_intake.toggleIntake(true);
        }
        else if(OIController.lBButton.get()){
            m_intake.toggleIntake(false);
        }
        else{
            m_intake.stop();
        }
    }
    @Override public void end(boolean interupted){
        System.out.println("end");
    }
    @Override public boolean isFinished() {
        return false;
    }
}
