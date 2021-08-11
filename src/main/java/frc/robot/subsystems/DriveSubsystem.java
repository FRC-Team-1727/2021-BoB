package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.DriveConstants.*;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;

public class DriveSubsystem extends SubsystemBase {
  private VictorSPX[] lDrive = new VictorSPX[]{
    new VictorSPX(kLDrivePort[0]),
    new VictorSPX(kLDrivePort[1])
  };
  private VictorSPX[] rDrive = new VictorSPX[]{
    new VictorSPX(kRDrivePort[0]),
    new VictorSPX(kRDrivePort[1])
  };
  private Encoder lEncoder = new Encoder(kLEncoderPort[0], kLEncoderPort[1], kLEncoderReverse, EncodingType.k4X);
  private Encoder rEncoder = new Encoder(kREncoderPort[0], kREncoderPort[1], kREncoderReverse, EncodingType.k4X);
  
  private double yAxis = 0;
  private double xAxis = 0;
  
  public DriveSubsystem() {
    lEncoder.setDistancePerPulse(6 * Math.PI / 256.0);
    rEncoder.setDistancePerPulse(6 * Math.PI / 256.0);
  }
  
  public void arcade(double y, double x){ //xbox y axis are reversed, so reverse the acutal parameter, not the formal parameter
    if(Math.abs(y) > 0.2){
      yAxis = y;
    }else{
      yAxis = 0;
    }
    if(Math.abs(x) > 0.2){
      xAxis = x;
    }else{
      xAxis = 0;
    }
    setDrive(yAxis + xAxis, yAxis - xAxis); //ask if driver wants to square drive
  }
  
  public void setDrive(double left, double right){
    setLDrive(left);
    setRDrive(right);
  }
  
  public void setLDrive(double spd){
    for(VictorSPX m : lDrive){
      m.set(ControlMode.PercentOutput, -spd); 
      //motors are reversed on robot, so when we fix electronics we need to make sure this and encoders match
    }
  }
  
  public void setRDrive(double spd){
    for(VictorSPX m : rDrive){
      m.set(ControlMode.PercentOutput, spd);
    }
  }
  //precondition: valid target available
  public void align(double angleX){
    
  }
  
  public void resetEncoders(){
    lEncoder.reset();
    rEncoder.reset();
  }
  
  //other functions for auton: driving straight a certain distance (inches) based on parameter, turning certain angle (degrees) based on parameter

}
