package frc.robot.commands;

import frc.robot.subsystems.UptakeSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import static frc.robot.Constants.XBoxConstants.*;
import java.util.function.DoubleSupplier;

public class UptakeCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final UptakeSubsystem m_uptakeSubsystem;
  private double speed;

  /*
   * @param subsystem The subsystem used by this command.
   */
  public UptakeCommand(UptakeSubsystem subsystem, DoubleSupplier spd) {
    m_uptakeSubsystem = subsystem;
    speed = spd.getAsValue();
    if(speed >= 0){
      if(speed < kTriggerThreshold){
        speed = 0;
      }else{
        speed = 1;
      }
    }
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_uptakeSubsystem);
  }
  
  public UptakeCommand(UptakeSubsystem subsystem, double spd){
    m_uptakeSubsystem = subsystem;
    addRequirements(m_uptakeSubsystem);
    speed = spd;
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_uptakeSubsystem.uptake(speed);
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
