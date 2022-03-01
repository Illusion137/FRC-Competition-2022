package nerds.utils;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
*frc::xboxController with commands binded to buttons
*/
public class OIController{
    public static final XboxController controller = new XboxController(Constants.XBOXCONTROLLERPORT);
    
    public static final JoystickButton aButton = new JoystickButton(controller, Constants.A.value);
    public static final JoystickButton bButton = new JoystickButton(controller, Constants.B.value);
    public static final JoystickButton yButton = new JoystickButton(controller, Constants.Y.value);
    public static final JoystickButton xButton = new JoystickButton(controller, Constants.X.value);
    public static final JoystickButton rBButton = new JoystickButton(controller, Constants.RB.value);
    public static final JoystickButton lBButton = new JoystickButton(controller, Constants.LB.value);
    public static final JoystickButton lSButton = new JoystickButton(controller, Constants.LS.value);
    public static final JoystickButton navButton = new JoystickButton(controller, Constants.LS.value);
    public static final JoystickButton startButton = new JoystickButton(controller, Constants.MENU.value);
    public static final JoystickButton rSButton = new JoystickButton(controller, Constants.NAVIGATION.value);

    public static final JoystickButton rTTrigger = new JoystickButton(controller, Constants.RT.value);
    public static final JoystickButton lTTrigger = new JoystickButton(controller, Constants.RT.value);
    public static final JoystickButton lS_X = new JoystickButton(controller, Constants.LS_X.value);
    public static final JoystickButton lS_Y = new JoystickButton(controller, Constants.LS_Y.value);

    // Dpad directions are stored in degrees
    public static int getDpad() {
        return controller.getPOV();
    }

    // Check if the current dpad pov equals the given direction's pov
    public static boolean isDpadPressed(DPadDirection dir) {
        return getDpad() == dir.get();
    }

    // Just helpful for readability
    public static enum DPadDirection {
        UP(0), DOWN(180), LEFT(270), RIGHT(90), NONE(-1);

        private int pov;

        public int get() {
            return pov;
        }

        private DPadDirection(int pov) {
            this.pov = pov;
        }
    }
}