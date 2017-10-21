package org.usfirst.frc.team1533.robot.commands;

import org.usfirst.frc.team1533.robot.Constants;
import org.usfirst.frc.team1533.robot.Robot;

import com.team254.frc2016.vision.TargetInfo;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class VisionLineup extends Command {
	double duration;
	double Y;
	double X;
	double r;
	double startTime;
	double dir;
	int sign;
	
	public VisionLineup(int duration){
	  this.duration=duration;
	}
	
	public void initialize() {
	    startTime = System.currentTimeMillis() / 1e3;
			
	}
	
	public void execute() {
		sign = DriverStation.getInstance().getAlliance().equals(Alliance.Red) ? 1 : -1;
		
		if(Robot.lastUpdate != null && Robot.lastUpdate.getTargets().size() > 0) {
	           TargetInfo target = Robot.lastUpdate.getTargets().get(0);
	           double yy = (Constants.VISION_Y_TARGET - target.getY())*12;
	           double xx = (Constants.VISION_X_TARGET - target.getX())*1;
	         yy = Math.max(-.3, Math.min(.3,yy));
	         xx = Math.max(-.3, Math.min(.3,xx));
	          
	         Robot.swerve.driveNormal(0,yy, xx);
	           
	        }
	
			
		
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
