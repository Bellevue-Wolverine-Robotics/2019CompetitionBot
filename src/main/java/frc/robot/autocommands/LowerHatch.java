/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autocommands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LowerHatch extends Command {
  public LowerHatch() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.hatchArm);
    requires(Robot.pidHatchArm);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if (Robot.hatchArm.getAngle() > 70) {
      Robot.pidHatchArm.setSetpoint(-0.1);
      Robot.pidHatchArm.enable();
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.hatchArm.getAngle() < 45;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.pidHatchArm.setSetpoint(0);
    Robot.pidHatchArm.disable();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}