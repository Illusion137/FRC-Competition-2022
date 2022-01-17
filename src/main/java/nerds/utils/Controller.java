package nerds.utils;

import java.util.HashMap;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;

/**
*frc::xboxController with commands binded to buttons
*/
public class Controller{

    public XboxController xboxController;
    private HashMap<Integer, Command> commandMap = new HashMap<Integer, Command>();

    public double controller_get_pov_dpad(int axis){
        xboxController.getPOV(axis);
        return 0;
    }

    public int getPOV(int POV){
        return 0;
    }

    public void controller_bind_command_button(XboxController.Button button, Command function){ commandMap.put(button.ordinal(),function); }

    public void controller_execute_button_function(XboxController.Button button) { commandMap.get(button.ordinal()); }
}