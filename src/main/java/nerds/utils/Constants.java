package nerds.utils;
import edu.wpi.first.wpilibj.XboxController;

public class Constants {
    //#region Controller-Buttons
        /*Remap buttons by swapping the varible name itself around*/
        //Buttons
            public static final XboxController.Button A = XboxController.Button.kA;
            public static final XboxController.Button B = XboxController.Button.kB;
            public static final XboxController.Button X = XboxController.Button.kX;
            public static final XboxController.Button Y = XboxController.Button.kY;
            public static final XboxController.Button lB = XboxController.Button.kLeftBumper;
            public static final XboxController.Button rB = XboxController.Button.kRightBumper;
            public static final XboxController.Button lS = XboxController.Button.kLeftStick;
            public static final XboxController.Button rS = XboxController.Button.kRightStick;
        //Axis
            public static final XboxController.Axis lS_Y = XboxController.Axis.kLeftY;
            public static final XboxController.Axis lS_X = XboxController.Axis.kLeftX;
            public static final XboxController.Axis rS_Y = XboxController.Axis.kRightY;
            public static final XboxController.Axis rS_X = XboxController.Axis.kRightX;
            public static final XboxController.Axis lT = XboxController.Axis.kLeftTrigger;
            public static final XboxController.Axis rT = XboxController.Axis.kRightTrigger;
    //#endregion
    // Measurements in cm
    public static final int upperHubHeight = 264;
}
