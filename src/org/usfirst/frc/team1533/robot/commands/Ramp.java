package org.usfirst.frc.team1533.robot.commands;

import org.usfirst.frc.team1533.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.Command;

public class Ramp extends Command {

	double duration;
	double startTime;
	int sign;
	public Ramp() {
		
	}

	public void initialize() {
		
	}

	public void execute() {
		Robot.shooter.autoShot();
	}

	protected boolean isFinished() {
		return false;
	}

	public void end() {
		Robot.shooter.setZero();
	}
}