package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShooterCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ShooterSubsystem m_shooterSubsystem;
  private double speed;

  /*
   * @param subsystem The subsystem used by this command.
   */
  public ShooterCommand(ShooterSubsystem subsystem, double spd) {
    m_shooterSubsystem = subsystem;
    speed = spd;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_shooterSubsystem);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_shooterSubsystem.setSpeed(speed);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
