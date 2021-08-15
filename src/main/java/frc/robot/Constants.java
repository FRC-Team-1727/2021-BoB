// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  
  public static final class DriveConstants{
    public static final int[] kLDrivePort = new int[] {3, 4};
    public static final int[] kLEncoderPort = new int[] {0, 1};
    public static final boolean kLEncoderReverse = true;
    
    public static final int[] kRDrivePort = new int[] {1, 2};
    public static final int[] kREncoderPort = new int[] {4, 5};
    public static final boolean kREncoderReverse = false;
    
    public static final double kThreshold = 0.2;
    public static final double kWheelDiameter = 6; //replace this with empirical wheel diameter after finding it
    public static final double kVisionP = 0.02;
    public static final double kVisionLimit = 0.008;
  }
  
  public static final class ShooterConstants{
    public static final double kP = 0.0008;
    public static final double kI = 0.000002;
    public static final double kD = 2;
    public static final double kF = 0;
    
    public static final int[] kFlywheelPort = new int[] {9, 10};
    public static final int kAllowableError = 60;
  }
  
  public static final class IntakeConstants{
    public static final int kIntakePort = 8;
    public static final int[] kIntakePistonPort = new int[] {1, 3};
  }
  
  public static final class ClimbConstants{
    public static final int[] kHookPorts = new int[] {0, 2};
    public static final int[] kClimbPorts1 = new int[] {4, 6};
    public static final int[] kClimbPorts2 = new int[] {5, 7};
  }
  
  public static final class XBoxConstants{
    public static final int kXBoxPort = 0;
    public static final double kTriggerThreshold = 0.2;
  }

}
