package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import static frc.robot.Constants.XBoxConstants.*;

public class IntakeMotorCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final IntakeSubsystem m_intakeSubsystem;
  private double speed;

  /*
   * @param subsystem The subsystem used by this command.
   */
  public IntakeMotorCommand(IntakeSubsystem subsystem, double spd) {
    m_intakeSubsystem = subsystem;
    if(spd <= 0){
      if(spd > -kTriggerThreshold){
        speed = 0;
      }else{
        speed = -1;
      }
    }else{
      speed = spd;
    }
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
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
