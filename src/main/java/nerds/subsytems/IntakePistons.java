package nerds.subsytems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import nerds.commands.ToggleIntake;
import nerds.commands.ToggleIntakePistons;
import nerds.utils.OIController;

public class IntakePistons extends SubsystemBase {
    
    public final DoubleSolenoid solenoidValves = new DoubleSolenoid(PneumaticsModuleType.CTREPCM,0, 1);
    public final Compressor compressorThang = new Compressor(PneumaticsModuleType.CTREPCM);

    private ToggleIntakePistons toggleCmd = new ToggleIntakePistons(this);

    public IntakePistons() {
        compressorThang.enableDigital();  
		OIController.yButton.whileActiveOnce(toggleCmd);
    }

    @Override public void periodic(){}

    public void togglePistons(){
        solenoidValves.toggle();
    };
}