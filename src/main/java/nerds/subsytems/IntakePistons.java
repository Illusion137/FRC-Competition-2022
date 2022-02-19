package nerds.subsytems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import nerds.commands.ToggleIntakePistons;
import nerds.utils.OIController;

public class IntakePistons extends SubsystemBase {
    //ask about parameters
    private final DoubleSolenoid solenoidValves = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,0, 1);
    public final Compressor compressorThang = new Compressor(PneumaticsModuleType.CTREPCM);

    public IntakePistons(){
        compressorThang.enableDigital();
        solenoidValves.set(Value.kForward);
        OIController.yButton.whenPressed(new ToggleIntakePistons(this));
    }

    @Override public void periodic(){}

    public void togglePistons(){
        solenoidValves.toggle();
    };
}