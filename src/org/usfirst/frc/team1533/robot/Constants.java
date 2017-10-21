package org.usfirst.frc.team1533.robot;

public class Constants {
	//Not a factory
	//Swerve
	
	// competition bot
	/*public final static double FL_ENC_OFFSET = -296+200-88+360+2;
	public final static double FR_ENC_OFFSET = -94-15+360+1+180;
	public final static double BL_ENC_OFFSET = -156+138+360-1;
	public final static double BR_ENC_OFFSET = -13-202+360+1+180;*/
	
	// practice bot
	public final static double FL_ENC_OFFSET = 360-114;
	public final static double FR_ENC_OFFSET = 360-290+180;
	public final static double BL_ENC_OFFSET = 360-228;
	public final static double BR_ENC_OFFSET = 360-249+180;

	public final static double WHEEL_BASE_WIDTH = 22.5;
	public final static double WHEEL_BASE_LENGTH = 26.5;

	//ButtonMap
	//square
	public final static int X = 1;
	//ecks
	public final static int A = 2;
	//circle
	public final static int B = 3;
	//triangle
	public final static int Y = 4;
	public final static int LEFT_BUMPER = 5;
	public final static int RIGHT_BUMPER = 6;
	public final static int LEFT_TRIGGER = 7;
	public final static int RIGHT_TRIGGER = 8;
	public final static int BACK = 9;
	public final static int START = 10;
	//back

	public final static double VISION_X_TARGET = 0.0895;
	public final static double VISION_Y_TARGET = 0.1508;
	
	/*
	 * PS2
	public final static int X = 4;
	public final static int A = 3;
	public final static int B = 2;
	public final static int Y = 1;

	 */


	public final static int X2 = 1;
	//ecks

	public final static int A2 = 2;
	//circle
	public final static int B2 = 3;
	//triangle
	public final static int Y2 = 4;


	public final static int LEFT_BUMPER2 = 5;
	public final static int RIGHT_BUMPER2 = 6;
	public final static int LEFT_TRIGGER2 = 7;
	public final static int RIGHT_TRIGGER2 = 8;


	//RobotMap
	public final static int FR_STEER = 6;
	public final static int BR_STEER = 8;
	public final static int BL_STEER = 9;
	public final static int FL_STEER = 7;

	public final static int FR_DRIVE = 0;
	public final static int BR_DRIVE = 2;
	public final static int BL_DRIVE = 3;
	public final static int FL_DRIVE = 1;

	public final static int SHOOTER = 0;
	public final static int SHOOTER_PIVOT = 5;
	public final static int SHOOTER_HOOD = 4;
	
	public final static int GEAR_ENCODER = 8;
	public final static int GEAR_LIFT = 11;
	public final static int SPIKE_SOLENOID = 0;
	public final static int GEAR_ROLLER = 10;

	public final static int FUEL_INTAKE = 14;

	public final static int HOPPER = 12;

	public final static int WINCH = 15;

	public final static int FR_ENCODER = 0;
	public final static int BR_ENCODER = 2;
	public final static int FL_ENCODER = 1;
	public final static int BL_ENCODER = 3;

	public static class Steering{
		//Swerve
		public final static double SWERVE_STEER_CAP = 1; 
		public final static double SWERVE_STEER_P = 2; 
		public final static double SWERVE_STEER_I = 0; 
		public final static double SWERVE_STEER_D = 0;

	}
}
