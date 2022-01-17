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
            public static final XboxController.Button LB = XboxController.Button.kLeftBumper;
            public static final XboxController.Button RB = XboxController.Button.kRightBumper;
            public static final XboxController.Button LS = XboxController.Button.kLeftStick;
            public static final XboxController.Button RS = XboxController.Button.kRightStick;
            public static final XboxController.Button START = XboxController.Button.kStart;
            public static final XboxController.Button BACK = XboxController.Button.kBack;
        //Axis
            public static final XboxController.Axis LS_Y = XboxController.Axis.kLeftY;
            public static final XboxController.Axis LS_X = XboxController.Axis.kLeftX;
            public static final XboxController.Axis RS_Y = XboxController.Axis.kRightY;
            public static final XboxController.Axis RS_X = XboxController.Axis.kRightX;
            public static final XboxController.Axis LT = XboxController.Axis.kLeftTrigger;
            public static final XboxController.Axis RT = XboxController.Axis.kRightTrigger;
    //#endregion
    // Math Constants
        float PI = 3.14159f;
    //Robotic Constants
        //Ports
            public static final int XBOXCONTROLLERPORT = 0;
        //Speeds
            //->
    // Measurements in cm
        public static final int upperHubHeight = 264;
}