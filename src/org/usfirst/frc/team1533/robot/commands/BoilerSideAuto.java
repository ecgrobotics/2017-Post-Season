package org.usfirst.frc.team1533.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BoilerSideAuto extends CommandGroup{
	public BoilerSideAuto(){
		addSequential(new BoilerSideGearArc(.325));
		addSequential(new GearDrop());
		addSequential(new GearReset());
	}

}
