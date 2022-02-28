package nerds.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import nerds.subsytems.Climber;
import nerds.utils.OIController;
import nerds.utils.OIController.DPadDirection;

public class RaiseArm extends CommandBase {
    
    public Climber climber;

    public RaiseArm(Climber climber) {
        this.climber = climber;
        addRequirements(climber);
    }

    @Override
    public void initialize() {
    }
    @Override
    public void execute() {
        if (OIController.getDpad() == OIController.DPadDirection.UP.get()) {
            climber.moveArm(true);
        } else if (OIController.getDpad() == DPadDirection.DOWN.get()) {
            climber.moveArm(false);
        } else if (OIController.getDpad() == DPadDirection.NONE.get()) {
            climber.stop();
        }
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
