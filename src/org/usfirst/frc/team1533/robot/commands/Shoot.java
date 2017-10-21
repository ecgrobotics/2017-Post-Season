package org.usfirst.frc.team1533.robot.commands;

import org.usfirst.frc.team1533.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.Command;

public class Shoot extends Command {

	double duration;
	double startTime;
	int sign;
	public Shoot() {
	
	}

	public void initialize() {
		startTime = System.currentTimeMillis() / 1e3;
		sign = DriverStation.getInstance().getAlliance().equals(Alliance.Red) ? -1 : 1;
	}

	public void execute() {
		if (timeSinceInitialized()%4.25 < .25){
			Robot.shooter.gumball.set(-.85);
			Robot.shooter.roller.set(1);
		}
			else if (timeSinceInitialized()%4.25 > .25)
			{
				Robot.shooter.gumball.set(.85);
				Robot.shooter.roller.set(1);
			}
		else{
			Robot.shooter.agitate();
		}
	}

	protected boolean isFinished() {
		return false;
	}

	public void end() {
		Robot.shooter.setZero();
	}
}