package frc.robot.commands;

import frc.robot.subsystems.ClimbSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class HookReleaseCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ClimbSubsystem m_climbSubsystem;
  private int state;
  /**
   * @param subsystem The subsystem used by this command.
   */
  public HookReleaseCommand(ClimbSubsystem subsystem, int st) {
    m_climbSubsystem = subsystem;
    state = st;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_climbSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_climbSubsystem.releaseHook(state);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
