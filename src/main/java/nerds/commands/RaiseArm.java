package nerds.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import nerds.subsytems.Climber;
import nerds.utils.OIController;
import nerds.utils.OIController.DPadDirection;

public class RaiseArm extends CommandBase {
    
    public Climber climber;

    public RaiseArm(Climber climber) {
        this.climber = climber;
    }

    @Override
    public void execute() {
        if (OIController.controller.getPOV() == OIController.DPadDirection.UP.get()) {
            climber.moveArm(true);
        } else if (OIController.getDpad() == DPadDirection.UP.get()) {
            climber.moveArm(false);
        }
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
