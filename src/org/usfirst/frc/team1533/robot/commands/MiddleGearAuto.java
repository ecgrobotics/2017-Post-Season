package org.usfirst.frc.team1533.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MiddleGearAuto extends CommandGroup {
	
	public MiddleGearAuto() {
		addSequential(new DriveForwardTime(4.2, .35));
		addSequential(new GearDrop());
		addSequential(new GearReset());
	}
}
