package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ClimbConstants;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kForward;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.kReverse;

public class ClimbSubsystem extends SubsystemBase {
  
  private DoubleSolenoid hook = new DoubleSolenoid(ClimbConstants.kHookPorts[0], ClimbConstants.kHookPorts[1]);
  private DoubleSolenoid[] climb = new DoubleSolenoid[] {new DoubleSolenoid(ClimbConstants.kClimbPorts1[0],
                                                                            ClimbConstants.kClimbPorts1[1]),
                                                         new DoubleSolenoid(ClimbConstants.kClimbPorts2[0],
                                                                            ClimbConstants.kClimbPorts2[1]) }
  //initializes pistons in reverse position so that we can use toggle() method
  for (DoubleSolenoid s : climb){
    s.set(kReverse);
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
