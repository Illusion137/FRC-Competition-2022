package nerds.subsytems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import nerds.commands.ToggleIntakePistons;

public class IntakePistons extends SubsystemBase {
    
    public final DoubleSolenoid solenoidValves = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,0, 1);
    public final Compressor compressorThang = new Compressor(PneumaticsModuleType.CTREPCM);

    public IntakePistons() {
        compressorThang.enableDigital();
        setDefaultCommand(new ToggleIntakePistons(this));
    }

    @Override public void periodic(){}

    public void togglePistons(){
        solenoidValves.toggle();
    };
}