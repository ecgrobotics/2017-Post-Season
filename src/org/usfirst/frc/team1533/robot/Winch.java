package org.usfirst.frc.team1533.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

public class Winch {
	Joystick joy;
	SpeedController winch;
	
	public Winch(Joystick joy){
		this.joy = joy;
		winch = new Spark(Constants.WINCH);
	}
	public void winch(){
		if(joy.getRawButton(Constants.X)){
			winch.set(-.25);
		}else if(joy.getRawButton(Constants.Y))
			winch.set(-1);
		else
			winch.set(0);
	}

}
