// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import static edu.wpi.first.wpilibj.XboxController.Button;

import frc.robot.commands.ExampleCommand;
import frc.robot.commands.IntakeMotorCommand;
import frc.robot.commands.IntakePistonCommand;
import frc.robot.commands.HookReleaseCommand;
import frc.robot.commands.ClimbCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.AimCommand;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.UptakeCommand;
import frc.robot.commands.TestDriveCommand;
import frc.robot.commands.InMotComdouble;
import frc.robot.commands.UpMotComdouble;
import frc.robot.commands.AutoCommand;

import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.VisionSubsystem;
import frc.robot.subsystems.UptakeSubsystem;

import edu.wpi.first.wpilibj2.command.Command;
import static frc.robot.Constants.XBoxConstants.*;
import java.util.function.DoubleSupplier;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final IntakeSubsystem m_intakeSubsystem = new IntakeSubsystem();
  private final ClimbSubsystem m_climbSubsystem = new ClimbSubsystem();
  private final ShooterSubsystem m_shooterSubsystem = new ShooterSubsystem();
  private final DriveSubsystem m_driveSubsystem = new DriveSubsystem();
  private final VisionSubsystem m_visionSubsystem = new VisionSubsystem();
  private final UptakeSubsystem m_uptakeSubsystem = new UptakeSubsystem();
    
  private final Command m_autoCommand = new AutoCommand(m_shooterSubsystem,m_driveSubsystem,m_uptakeSubsystem);
  
  XboxController xbox = new XboxController(kXBoxPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    //default commands
    m_shooterSubsystem.setDefaultCommand(new ShooterCommand(m_shooterSubsystem, 3650));
    /*^speed from auto. if default speed should be something else then we can set speed to this in auto and it will go to default
    when all commands get canceled when we go into teleop*/
    
    m_driveSubsystem.setDefaultCommand(new DriveCommand(m_driveSubsystem,()->-xbox.getY(GenericHID.Hand.kRight), ()->xbox.getX(GenericHID.Hand.kLeft)));

    m_intakeSubsystem.setDefaultCommand(new IntakeMotorCommand(m_intakeSubsystem, ()-> -xbox.getTriggerAxis(GenericHID.Hand.kRight)));
    //left trigger: uptake
    m_uptakeSubsystem.setDefaultCommand(new UptakeCommand(m_uptakeSubsystem, ()-> xbox.getTriggerAxis(GenericHID.Hand.kLeft)));
    
    m_climbSubsystem.setDefaultCommand(new HookReleaseCommand(m_climbSubsystem, 0));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    
    //climb bindings
    new JoystickButton(xbox, Button.kB.value).whenPressed(new HookReleaseCommand(m_climbSubsystem, 1).withTimeout(2));
    new JoystickButton(xbox, Button.kB.value).whenPressed(new ShooterCommand(m_shooterSubsystem, 0));
    new JoystickButton(xbox, Button.kA.value).whenPressed(new ClimbCommand(m_climbSubsystem));
    //intake bindings
    new JoystickButton(xbox, Button.kBumperRight.value).whenPressed(new IntakePistonCommand(m_intakeSubsystem));
    new JoystickButton(xbox, Button.kY.value).whileHeld(new InMotComdouble(m_intakeSubsystem, 1));
    //uptake bindings
    new JoystickButton(xbox, Button.kX.value).whileHeld(new UpMotComdouble(m_uptakeSubsystem, -1));
    //shooter bindings
    new JoystickButton(xbox, Button.kBack.value).whenPressed(new ShooterCommand(m_shooterSubsystem, 4500));
    new JoystickButton(xbox, Button.kStart.value).whenPressed(new ShooterCommand(m_shooterSubsystem, 3650));
    new JoystickButton(xbox, Button.kBumperLeft.value).whileHeld(new AimCommand(m_driveSubsystem, m_shooterSubsystem, m_visionSubsystem));
    
    
    //TEST BINDINGS FOR DRIVE, comment out default command 
    // new JoystickButton(xbox, Button.kY.value).whileHeld(new TestDriveCommand(m_driveSubsystem, 0.4, true, true));
    // new JoystickButton(xbox, Button.kA.value).whileHeld(new TestDriveCommand(m_driveSubsystem, -0.4, true, true));
    // new JoystickButton(xbox, Button.kX.value).whileHeld(new TestDriveCommand(m_driveSubsystem, 0.4, false, true));
    // new JoystickButton(xbox, Button.kB.value).whileHeld(new TestDriveCommand(m_driveSubsystem, 0.4, true, false));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}

