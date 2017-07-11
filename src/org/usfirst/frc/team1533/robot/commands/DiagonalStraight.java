package org.usfirst.frc.team1533.robot.commands;

import org.usfirst.frc.team1533.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DiagonalStraight extends Command{
	double xVal,yVal;
	double percentage;
	double time, startTime;

	public DiagonalStraight(double angle, double time, double percentage){
		angle = angle*Math.PI/180;
		xVal = Math.cos(angle);
		yVal = Math.sin(angle);
		this.percentage = percentage;
		this.time = time;
		double tempY = 1/yVal;
		double tempX = 1/xVal;
		if(tempY>tempX){
			yVal = percentage;
			xVal = yVal/Math.tan(angle);
		}else if(tempX>tempY){
			xVal = percentage;
			yVal = xVal*Math.tan(angle);
		}else{
			xVal = percentage;
			yVal = percentage;
		}

	}
	public void initialize() {
		startTime = System.currentTimeMillis() / 1e3;
	}

	public void execute() {
		Robot.swerve.driveNormal(xVal, yVal, -Robot.gyro.getAngle() * 0.01);
	}

	public void end() {
		Robot.swerve.driveNormal(0, 0, 0);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return System.currentTimeMillis() / 1e3 - startTime >= time;
	}

}
