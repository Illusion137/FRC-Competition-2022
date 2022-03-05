package nerds.subsytems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import nerds.commands.RaiseArm;
import nerds.utils.OIController;

public class Climber extends SubsystemBase {

    public WPI_VictorSPX motor1 = new WPI_VictorSPX(6);
    public WPI_VictorSPX motor2 = new WPI_VictorSPX(7);

    MotorControllerGroup climbeGroup = new MotorControllerGroup(motor1, motor2);
    public Climber() {
        setDefaultCommand(new RaiseArm(this));
    }

    @Override
    public void periodic() {}

    public void stop() {
        motor1.stopMotor();
        motor2.stopMotor();
    }

    public void moveArm(boolean up) {
        // Set to brake mode so the arm has more resistance to hold the robot up
        motor1.setNeutralMode(NeutralMode.Brake);
        motor2.setNeutralMode(NeutralMode.Brake);
        
        if (up) {
            // Set the motors to go forward at the speed of the axis that the right trigger is held
            climbeGroup.set(OIController.controller.getRightTriggerAxis());
        } else {
            // Set the motors to go backward at the speed of the axis that the right trigger is held
            climbeGroup.set(-OIController.controller.getRightTriggerAxis());
        }
    }
}