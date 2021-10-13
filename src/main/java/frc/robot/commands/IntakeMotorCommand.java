package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import static frc.robot.Constants.XBoxConstants.*;
import java.util.function.DoubleSupplier;


public class IntakeMotorCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final IntakeSubsystem m_intakeSubsystem;
  private double speed;
  

  /*
   * @param subsystem The subsystem used by this command.
   */
  public IntakeMotorCommand(IntakeSubsystem subsystem, DoubleSupplier spd) {
    m_intakeSubsystem = subsystem;
    speed = spd.getAsDouble();
    if(speed <= 0){
      if(speed > -kTriggerThreshold){
        speed = 0;
      }else{
        speed = -1;
      }
    }
    //TRY: uncomment this if moving the above code to execute(){}
    //speed = spd;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_intakeSubsystem);
  }
  //overloaded constructor
  public IntakeMotorCommand(IntakeSubsystem subsystem, double spd){
    m_intakeSubsystem = subsystem;
    addRequirements(m_intakeSubsystem);
    speed = spd;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
//TRY: if intake trigger still isn't working, try moving the part of the code that takes care of thresholds here in the execute function
//     if(speed <= 0){
//       if(speed > -kTriggerThreshold){
//         speed = 0;
//       }else{
//         speed = -1;
//       }
//     }else{
//       speed = spd;
//     }
//TRY: if this doesn't work either, try passing in the xbox controller to this command and have execute(){} constantly pull inputs from xbox
    m_intakeSubsystem.intake(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
