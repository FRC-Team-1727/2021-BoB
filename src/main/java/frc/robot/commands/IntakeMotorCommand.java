package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeMotorCommand extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final IntakeSubsystem m_intakeSubsystem;
  private double speed;

  /*
   * @param subsystem The subsystem used by this command.
   */
  public IntakeMotorCommand(IntakeSubsystem subsystem, double spd) {
    m_intakeSubsystem = subsystem;
    speed = spd;
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
  public void end(boolean interrupted) {
    m_intakeSubsystem.intake(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

/* note: old code has a functionality where pressing the uptake button will automatically set intake at -1 speed
also, old code sets intake speed the same as -xbox trigger value, meaning as it gets pressed down the intake speed will go
from 0 -> -1 in the duration of the trigger press rather than current (8/8/21) way of setting it immediately at -1

other things to consider:
- current intended way to work is to have this command run on the wpilib button whileHeld condition so that it will automatically
cancel itself when button is released
*/
