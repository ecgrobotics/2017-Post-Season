package org.usfirst.frc.team1533.robot.commands;

import org.usfirst.frc.team1533.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveFieldTime extends Command {
	double duration;
	double Y;
	double X;
	double r;
	double startTime;
	double dir;
	int sign;
	
	public DriveFieldTime(double duration, double Y, double X, double r) {
		this.duration = duration;
		this.Y = Y;
		this.X = X;
		this.r = r;
	}
	
	public void initialize() {
		startTime = System.currentTimeMillis() / 1e3;
//		if(r > 181)
	//		dir =1;
		//else
			//dir=-1;
			
	}
	
	public void execute() {
		sign = DriverStation.getInstance().getAlliance().equals(Alliance.Red) ? 1 : -1;
		Robot.swerve.driveField(X*sign, Y, r*sign);
	
			
		
		//SmartDashboard.putNumber("Gyro Stuff", (Robot.gyro.getAngle()-r)/360);
		//if(Math.abs(Robot.gyro.getAngle() - r) > 5)
		//Robot.swerve.driveField(0, 0, 2*(Robot.gyro.getAngle() - r)/360);
		//else
		//	Robot.swerve.driveField(0, 0, 0);
	}
	
	protected boolean isFinished() {
		return System.currentTimeMillis() / 1e3 - startTime >= duration;
	}
	
	public void end() {
		Robot.swerve.driveField(0, 0, 0);
	}

}
