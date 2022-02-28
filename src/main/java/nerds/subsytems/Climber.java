package nerds.subsytems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import nerds.commands.RaiseArm;

public class Climber extends SubsystemBase {

    public WPI_VictorSPX motor1 = new WPI_VictorSPX(6);
    public WPI_VictorSPX motor2 = new WPI_VictorSPX(7);

    public Climber() {
        setDefaultCommand(new RaiseArm(this));
    }

    public void moveArm(boolean up) {
        if (up) {
            motor1.set(0.1);
            motor2.set(0.1);
        } else {
            motor1.set(-0.1);
            motor2.set(-0.1);
        }
    }
}