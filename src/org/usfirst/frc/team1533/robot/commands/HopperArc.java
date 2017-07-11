package org.usfirst.frc.team1533.robot.commands;

import org.usfirst.frc.team1533.robot.GearIntake;
import org.usfirst.frc.team1533.robot.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class HopperArc extends Command {
	double speed;
	int sign;
	
	public HopperArc(double speed) {
		this.speed = Math.abs(speed);
	}
	
	public void initialize() {
	    speed= SmartDashboard.getNumber("Speed",0);
	    
		sign = DriverStation.getInstance().getAlliance().equals(Alliance.Red) ? 1 :-1;
		Robot.swerve.setPivot(SmartDashboard.getNumber("x",-15), SmartDashboard.getNumber("y",75));
		SmartDashboard.putNumber("Gyro", Robot.gyro.getAngle());
		Robot.gyro.reset();
		
	}
	
	public void execute() {
		Robot.swerve.driveNormal(0, 0, sign * speed);	
		
		
	}
	
	protected boolean isFinished() {
		return Math.abs(Robot.gyro.getAngle()) >= 90;
	}
	
	public void end() {
		Robot.swerve.setPivot(0, 0);
		Robot.swerve.driveNormal(0, 0, 0);
	}
	
	public void interrupted() {
		end();
	}
	

			
		}
	

