package org.usfirst.frc.team1533.robot.commands;

import org.usfirst.frc.team1533.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GearReset extends Command{
	double startTime;
	public void execute(){
		Robot.gear.liftPID.disable();
		Robot.gear.liftPID.setSetpoint(0);
		Robot.gear.encoder.reset();
		Robot.gear.gearlift.set(-0.5);
//		Robot.gear.roller.set(-1);
	}
	public void   initialize() {
		startTime = System.currentTimeMillis() / 1e3;
	}


	public boolean isFinished(){
		return System.currentTimeMillis() / 1e3 - startTime >= .75;
	}
	public void end() {
	}
}
