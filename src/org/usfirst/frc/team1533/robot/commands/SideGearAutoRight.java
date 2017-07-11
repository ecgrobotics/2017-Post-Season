package org.usfirst.frc.team1533.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class SideGearAutoRight extends CommandGroup {
	
	public SideGearAutoRight() {
		
		addSequential(new DriveFieldTime(2.2, -.36, -.45, 0));
		
	}
}
