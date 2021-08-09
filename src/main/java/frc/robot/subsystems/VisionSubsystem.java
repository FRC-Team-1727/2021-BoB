package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import.edu.wpi.first.networktables.NetworkTableInstance;

public class VisionSubsystem extends SubsystemBase {
  
  private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  
  public boolean hasTarget(){
    if(table.getEntry("tv").getDouble(0) == 1){
      return true;
    }
    return false;
  }
  
  public double getAngleX(){
    return table.getEntry("tx").getDouble(0);
  }
  
  public double getArea(){
    return table.getEntry("ta").getDouble(0);
  }
  
}
