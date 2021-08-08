package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.IntakeConstants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

public class IntakeSubsystem extends SubsystemBase {
  private VictorSPX intake = new VictorSPX(kIntakePort);
  private DoubleSolenoid intakePiston = new DoubleSolenoid(kIntakePistonPort[0], kIntakePistonPort[1]);
  //initializes intakePiston in current position so that it can use toggle() method
  intakePiston.set(intakePiston.get());
  
  //sets the intake roller motor at percent speed spd
  public void intake(double spd){
    intake.set(ControlMode.PercentOutput, spd);
  }
  
  //toggles the intake pistons between in and out position
  public void intakePiston(){
    intakePiston.toggle();
  }
  
}
