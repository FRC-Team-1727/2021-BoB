package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.VisionSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class AutoCommand {
    private final ShooterSubsystem shooterSubsystem;
    private final DriveSubsystem driveSubsystem;
    
    
    public AutoCommand() {
        shooterSystem.setSpeed(3200);
    }
    
    public void driveForward(int distance, int speed){
        double error = 10;

        while (error > autonError){
            double lError = distance - lEncoder;
            double rError = distance - rEncoder;
            driveSubsystem.setDrive(lError * speed * autonKP,rError * speed * autonKP);
            error = (lError + rError)/2;
        }
    }
    
    public void turn(int distance, int speed){
        double error = 10;

        while (error > autonError){
            double lError = distance - lEncoder;
            double rError = distance - rEncoder;
            driveSubsystem.setDrive(-lError * speed * autonKP,rError * speed * autonKP);
            error = (lError + rError)/2;
        }
    }
    
    
}