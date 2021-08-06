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
    public static final double kWheelDiameter = 6; //replace this with empirical wheel diameter after finding it
    
  }
  
  public static final class ShooterConstants{
    public static final double kP = 0.0008;
    public static final double kI = 0.000002;
    public static final double kD = 2;
    
  }
  
  public static final class ClimbConstants{
    public static final int[] kHookPorts = new int[] {0, 2};
    public static final int[] kClimbPorts1 = new int[] {4, 6};
    public static final int[] kClimbPorts2 = new int[] {5, 7};
  }

}
