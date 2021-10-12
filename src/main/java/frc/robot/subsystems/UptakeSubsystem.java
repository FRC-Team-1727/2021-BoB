package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.UptakeConstants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class UptakeSubsystem extends SubsystemBase {
  
  private VictorSPX uptake = new VictorSPX(kUptakePort);
  private VictorSPX vLeft = new VictorSPX(kVLeftPort);
  private VictorSPX vRight = new VictorSPX(kVRightPort);
  
  public UptakeSubsystem(){}
  
  public void uptake(double spd){
    //sets v-belt and vertical uptake (feed) motors at speed spd
    //multipliers can be applied to different parts for different speeds
    uptake.set(ControlMode.PercentOutput, -spd);
    vLeft.set(ControlMode.PercentOutput, kVLeftMultiplier * spd);
    vRight.set(ControlMode.PercentOutput, kVRightMultiplier * spd);
  }
  
}
