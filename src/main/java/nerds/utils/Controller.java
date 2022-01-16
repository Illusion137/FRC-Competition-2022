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

    /**Represents a button on xbox controller; excludes axis based buttons|triggers|joysticks */
    public enum controller_enum_Button{
        A(0),B(1),Y(2),X(3),LB(4),RB(5),LS(6),RS(7),NAVIGATION(8),MENU(9);
        public final Integer i;
        private controller_enum_Button(Integer i){
            this.i = i;
        }
    };
    public enum controller_enum_Axis{
        LT,RT,LEFTSTICK_X,LEFTSTICK_Y,RIGHTSTICK_X,RIGHTSTICK_Y,DPAD_RIGHT,DPAD_DOWN,DPAD_LEFT,DPAD_UP
    };
    public void controller_bind_command_button(controller_enum_Button button, Command function){ commandMap.put(button.ordinal(),function); }
    public void controller_bind_command_axis(controller_enum_Axis axis, Command function){ commandMap.put(axis.ordinal(),function); }

    public void controller_execute_button_function(controller_enum_Button button) { commandMap.get(button.ordinal()); }
}