package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.ShooterConstants.*;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;

public class ShooterSubsystem extends SubsystemBase {
  
  private CANSparkMax[] flywheel = new CANSparkMax[] {
    new CANSparkMax(kFlywheelPort[0], MotorType.kBrushless),
    new CANSparkMax(kFlywheelPort[1], MotorType.kBrushless)
  };
  
  private CANEncoder encoder = flywheel[0].getEncoder();
  private CANPIDController controller = flywheel[0].getPIDController();
  
  private double setpoint = 0;
  
  public ShooterSubsystem() {
    flywheel[1].follow(flywheel[0], true);
    flywheel[0].set(0);
    for(CANSparkMax m : flywheel){
      m.setIdleMode(IdleMode.kCoast);
    }
    
    controller.setFeedbackDevice(encoder);
    stop();
    updateConstants();
  }
  
  public boolean canShoot(){ //need to figure out how to coordinate this method with uptake command
    return Math.abs(encoder.getVelocity() - setpoint) < 60;
  }
  
  public void setSpeed(double stpt){
    setpoint = stpt;
    if(setpoint < 1){ // < 1 instead of == 0 in case of round-off error with doubles
      controller.setReference(0, ControlType.kVoltage);
    }else{
      controller.setReference(setpoint, ControlType.kVelocity);
    }
  }
  
  //precondition: target available (call this method in AimCommand in if statement that checks for target with VisionSubsystem)
  public void adjust(double area){
    setpoint = getSetPoint(area);
    if(setpoint < 1){ 
      controller.setReference(0, ControlType.kVoltage);
    }else{
      controller.setReference(setpoint, ControlType.kVelocity);
    }
  }
  
  public double getSetpoint(double area){
    return (448.058 * Math.pow((area - 1.880411), 2)) + 3321.09; //I don't think using constants would make sense here
  }
  
  public void stop(){
    controller.setReference(0, ControlType.kDutyCycle); //duty cycle is the percentage of time the digital signal is high/on
  }
  
  private void updateConstants(){
    controller.setOutputRange(0, 1);
    controller.setP(kP);
    controller.setI(kI);
    controller.setD(kD);
    Controller.setFF(kF);
  }

}
