package nerds.subsytems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import nerds.commands.ToggleIntake;
import nerds.utils.Constants;

public class Intake extends SubsystemBase{
    private final CANSparkMax intakeMotor = new CANSparkMax(5, MotorType.kBrushless);
    public Intake(){
        setDefaultCommand(new ToggleIntake(this));
    }
    @Override public void periodic(){}
    public void stop(){
        intakeMotor.stopMotor();
    }
    public void toggleIntake(boolean intakeIn){
        if(intakeIn){
            intakeMotor.set(Constants.INTAKESPEED);
        }
        else{
            intakeMotor.set(-Constants.INTAKESPEED);
        }
    }
}
