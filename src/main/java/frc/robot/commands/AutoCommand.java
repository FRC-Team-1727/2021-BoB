package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.VisionSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.UptakeSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Timer;

public class AutoCommand extends CommandBase{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final ShooterSubsystem shooterSubsystem;
    private final DriveSubsystem driveSubsystem;
    private final UptakeSubsystem uptakeSubsystem;
    
    
    public AutoCommand(ShooterSubsystem shooter, DriveSubsystem drive, UptakeSubsystem uptake) {
        shooterSubsystem = shooter;
        driveSubsystem = drive;
        uptakeSubsystem = uptake;
    }

    // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
        shooterSubsystem.setSpeed(3650);
        Timer.delay(6);
        uptakeSubsystem.uptake(1);
        Timer.delay(4);
        uptakeSubsystem.uptake(0);
        driveSubsystem.setDrive(-0.25,-0.25);
        Timer.delay(5);
        driveSubsystem.setDrive(0,0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
      driveSubsystem.setDrive(0, 0);
      System.out.println("end auton");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
    
    
    /*
    public void turn(int distance, int speed){
        double error = 10;
        driveSubsystem.resetEncoders();
        while (error > autonError){
            double lError = Math.abs(distance - driveSubsystem.lEncoder);
            double rError = Math.abs(distance - driveSubsystem.rEncoder);
            driveSubsystem.setDrive(-lError * speed * autonKP,rError * speed * autonKP);
            error = (lError + rError)/2;
        }
    }
    
    */
}
