package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.ClimbConstants.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;

public class ClimbSubsystem extends SubsystemBase {
  
  private DoubleSolenoid hook = new DoubleSolenoid(kHookPorts[0], kHookPorts[1]);
  private DoubleSolenoid[] climb = new DoubleSolenoid[] {
    new DoubleSolenoid(kClimbPorts1[0],kClimbPorts1[1]),
    new DoubleSolenoid(kClimbPorts2[0],kClimbPorts2[1]) 
  };
  //initializes pistons in current position so that they can use toggle() method
  public ClimbSubsystem(){
    for (DoubleSolenoid s : climb){
      s.set(s.get());
    }
  }
  
  //retracts the tiny piston to extend the hooks
  public void releaseHook(){
    hook.set(kReverse);
  }
  
  //toggles the state of the climb pistons
  public void toggleClimb(){
    for (DoubleSolenoid s : climb){
      s.toggle();
    }
  }
  
}
