package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem m_driveSubsystem;
  private double yAxis;
  private double xAxis;

  /*
   * @param subsystem The subsystem used by this command.
   */
  public DriveCommand(DriveSubsystem subsystem, double y, double x) {
    m_driveSubsystem = subsystem;
    yAxis = y;
    xAxis = x;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    arcade(yAxis, xAxis);
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
