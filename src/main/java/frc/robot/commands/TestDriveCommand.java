package frc.robot.commands;

import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TestDriveCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DriveSubsystem m_driveSubsystem;
  private double speed;
  private boolean left;
  private boolean right;
  /*
   * @param subsystem The subsystem used by this command.
   */
  public TestDriveCommand(DriveSubsystem subsystem, double spd, boolean l, boolean r) {
    //replace paramenters with DoubleSupplier y, DoubleSupplier x
    m_driveSubsystem = subsystem;
    speed = spd;
    left = l;
    right = r;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_driveSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(left){
      m_driveSubsystem.setLDrive(speed);
    }
    if(right){
      m_driveSubsystem.setRDrive(speed);
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
