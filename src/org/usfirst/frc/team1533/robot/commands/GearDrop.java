package org.usfirst.frc.team1533.robot.commands;

import org.usfirst.frc.team1533.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GearDrop extends Command{

	public void execute(){
		Robot.gear.liftPID.setSetpoint(25);
		if((.100) < timeSinceInitialized())
			Robot.gear.roller.set(-1);
		Robot.swerve.driveNormal(0, -.35, 0);
	}

	public boolean isFinished(){
		return timeSinceInitialized()>2;

	}
	public void end() {
		Robot.swerve.driveNormal(0, 0, 0);
		Robot.gear.roller.set(0);
	}
}
