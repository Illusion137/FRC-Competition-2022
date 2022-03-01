package nerds.subsytems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import nerds.commands.RaiseArm;
import nerds.utils.Constants;
import nerds.utils.OIController;

public class Climber extends SubsystemBase {

    public WPI_VictorSPX motor1 = new WPI_VictorSPX(6);
    public WPI_VictorSPX motor2 = new WPI_VictorSPX(7);

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
        if (up) {
            motor1.set(OIController.controller.getRightTriggerAxis());
            motor2.set(OIController.controller.getRightTriggerAxis());
        } else {
            motor1.set(-OIController.controller.getRightTriggerAxis());
            motor2.set(-OIController.controller.getRightTriggerAxis());
        }
    }
}