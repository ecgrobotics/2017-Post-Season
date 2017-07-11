package org.usfirst.frc.team1533.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class fortyKPAuto extends CommandGroup{
	public fortyKPAuto(){
	    addParallel(new Ramp());
		addSequential(new DriveDiagonalTime(2.5,.5,45));
		addSequential(new DriveDiagonalTime(1.25,.5, -80));
		addSequential(new WaitCommand(2.5));
		addSequential(new DriveDiagonalTime(.5, .5, 180));
		addParallel(new VisionLineup(3));
		addSequential(new Shoot());
	}

}
