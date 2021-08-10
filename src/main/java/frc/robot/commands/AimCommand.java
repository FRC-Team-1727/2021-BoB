package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.VisionSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class AimCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystme m_driveSubsystem;
  private final ShooterSubsystem m_shooterSubsystem;
  private final VisionSubsystem m_visionSubsystem;

  /*
   * @param subsystem The subsystem used by this command.
   */
  public AimCommand(DriveSubsystem dSubsystem, ShooterSubsystem sSubsystem, VisionSubsystem vSubsystem) {
    m_driveSubsystem = dSubsystem;
    m_shooterSubsystem = sSubsystem;
    m_visionSubsystem = vSubsystem;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_driveSubsystem, m_shooterSubsystem, m_visionSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(m_visionSubsystem.hasTarget()){
      m_shooterSubsystem.adjust(m_visionSubsystem.getArea());
      //m_driveSubsystem.align(m_visionSubsystem.getAngleX()); uncomment this when DriveSubsystem gets implemented
    }
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
