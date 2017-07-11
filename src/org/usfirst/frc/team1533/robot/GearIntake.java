package org.usfirst.frc.team1533.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GearIntake {
	public SpeedController gearlift, roller;
	Joystick joy;
	boolean toggle = false, prev = false;
	boolean gearUp = true;
	public Encoder encoder;
	public PIDController liftPID;
	public GearIntake(Joystick joy){
		gearlift = new Spark(Constants.GEAR_LIFT);
		roller = new Spark(Constants.GEAR_ROLLER);
		this.joy = joy;
		encoder = new Encoder(Constants.GEAR_ENCODER, Constants.GEAR_ENCODER+1);
		encoder.setDistancePerPulse((double)360/4096);
		liftPID = new PIDController(0.08, 0.0, 0.1, encoder, gearlift);
		liftPID.setOutputRange(-.5, .35);
		
		liftPID.setSetpoint(0);
		liftPID.enable();
	}
	public void gear(){
		if (joy.getRawButton(11)) {
			liftPID.disable();
			liftPID.setSetpoint(0);
			encoder.reset();
			gearlift.set(-0.5);
		} else {
			liftPID.enable();
			double gear = joy.getRawAxis(1);
			if(gear > 0.5){
				liftPID.setSetpoint(27);
			} else if(gear < -0.5){
				liftPID.setSetpoint(0);
			}
			//gearlift.set(joy.getRawAxis(1));
			else if(joy.getPOV()>-1){
				liftPID.setSetpoint(15);
			}
		}
		SmartDashboard.putNumber("Encoder", encoder.getDistance());
		
		if(joy.getRawButton(Constants.B)){
			roller.set(-1);
		}
		else if(joy.getRawButton(Constants.A)){
			roller.set(.75);
		} else{
			roller.set(-0);
		}
	}
}
