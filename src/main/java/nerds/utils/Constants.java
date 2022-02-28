package nerds.utils;

import edu.wpi.first.wpilibj.XboxController;
import nerds.subsytems.*;

public class Constants {
    
    /* Remap buttons by swapping the varible name itself around */

    //Buttons
    public static final XboxController.Button A = XboxController.Button.kA
        ,B = XboxController.Button.kB
        ,X = XboxController.Button.kX
        ,Y = XboxController.Button.kY
        ,LB = XboxController.Button.kLeftBumper
        ,RB = XboxController.Button.kRightBumper
        ,LS = XboxController.Button.kLeftStick
        ,RS = XboxController.Button.kRightStick
        ,MENU = XboxController.Button.kStart
        ,NAVIGATION = XboxController.Button.kBack;
    //Trigger.Axis
    public static final XboxController.Axis LS_Y = XboxController.Axis.kLeftY
        ,LS_X = XboxController.Axis.kLeftX
        ,RS_Y = XboxController.Axis.kRightY
        ,RS_X = XboxController.Axis.kRightX
        ,LT = XboxController.Axis.kLeftTrigger
        ,RT = XboxController.Axis.kRightTrigger;

    //Axis/Dpad
    public static final int DPAD_LEFT = 90;

    // Math Constants
    public static final float PI = 3.14159f;
    
    /* Robotic Constants */
    
    //Subsystems
    public final static double INTAKESPEED = 0.5;
    
    //Commands

    //Ports
    public static final int XBOXCONTROLLERPORT = 0;
    
    //Can
    public static final int LEFTBACKMOTORPORT = 1
        ,LEFTFRONTKMOTORPORT = 3
        ,RIGHTBACKMOTORPORT = 2
        ,RIGHTFRONTMOTORPORT = 4;

    /* Subsytems & Commands */

    public static final DriveTrain driveTrain_ = new DriveTrain();
    public static final Intake intake_ = new Intake();
    public static final IntakePistons intakePistons_ = new IntakePistons();
    public static final Climber climber = new Climber();
}