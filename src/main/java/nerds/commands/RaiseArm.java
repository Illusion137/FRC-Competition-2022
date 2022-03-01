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
        // Get the directon of the dpad and move the arm accordingly 
        if (OIController.isDpadPressed(DPadDirection.UP)) {
            climber.moveArm(true);
        } else if (OIController.isDpadPressed(DPadDirection.DOWN)) {
            climber.moveArm(false);
        } else if (OIController.isDpadPressed(DPadDirection.NONE)) {
            // Make sure that the motors are not running when no dpad input is pressed
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
