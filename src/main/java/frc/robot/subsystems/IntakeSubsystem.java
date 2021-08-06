package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;

public class IntakeSubsystem extends SubsystemBase {
  private VictorSPX intake = new VictorSPX(IntakeConstants.kIntakePort);
  private DoubleSolenoid intakePiston = new DoubleSolenoid(IntakeConstants.kIntakePistonPort[0], IntakeConstants.kIntakePistonPort[1]);
  //initializes intakePiston to start in the reverse position so that we can use toggle() method
  intakePiston.set(kReverse);
  
  //sets the intake roller motor at speed spd
  public void intake(double spd){
    intake.set(ControlMode.PercentOutput, spd);
  }
  
  //toggles the intake pistons between in and out position
  public void intakePiston(){
    intakePiston.toggle();
  }
  
}
