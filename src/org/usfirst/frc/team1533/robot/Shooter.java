package org.usfirst.frc.team1533.robot;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import com.ctre.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shooter {
 
	static final double PEAK_NATIVE = 28000;
	static final double F_GAIN = 1023 / PEAK_NATIVE;

	CANTalon shooter;
	public SpeedController roller, gumball;
	Joystick joy;
	double theta = 0.5, phi = 0.5;
	int loops = 0;
	boolean fast = false;
	boolean prev = false, toggle = false, prevOut = false, toggleOut = false, hopPrev = false;
	StringBuilder _sb = new StringBuilder();
	long time;
	
	public Shooter(Joystick joy){
		roller = new Spark(Constants.FUEL_INTAKE);
		gumball = new Spark(Constants.HOPPER);
		this.joy = joy;
		shooter = new CANTalon(Constants.SHOOTER);
		//		shooter.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		shooter.reverseSensor(true);
		shooter.configNominalOutputVoltage(0, 0);
		shooter.configPeakOutputVoltage(12, -12);
		shooter.setF(F_GAIN);
		shooter.setP(0.6);
		
		shooter.setI(0.00);
		shooter.setD(1.3);
		time = System.currentTimeMillis();
	}
	public void init(){
		theta = 0;
	}

	public void autoShot(){
		shooter.changeControlMode(TalonControlMode.Speed);
		SmartDashboard.putNumber("shooter speed", shooter.getSpeed());
		SmartDashboard.putNumber("shooter error", Math.abs(shooter.getSetpoint()-shooter.getSpeed()));
		rampShooter(15650);
	}
	public void agitate(){
		roller.set(1);
		gumball.set(.85);
		
	}
	public void setZero(){
		gumball.set(0);
		roller.set(0);
		shooter.changeControlMode(TalonControlMode.PercentVbus);
		shooter.set(0);
	}
	public void rampShooter(double speed) {
	    shooter.set(Math.min(speed, shooter.getSpeed()+800));
	}
	public void shoot(){
		//stir that hopper
		if(joy.getRawAxis(2) >= .3){
			gumball.set(.851533);
		}
		else if(joy.getRawAxis(2)<=-.3){
			
		if(System.currentTimeMillis()%4250 < 4000)
			{
				gumball.set(.851533);
			}
			else 
			{
				gumball.set(-.851533);
			}
		}
		    else 
		    {	
		    	gumball.set(0);
		    }
		//shooter
		if(joy.getRawButton(Constants.RIGHT_BUMPER)) {
//			shooter.changeControlMode(TalonControlMode.PercentVbus);
//			shooter.set(1);
			shooter.changeControlMode(TalonControlMode.Speed);
			rampShooter(15650);
			phi = 0;
			time = System.currentTimeMillis();
		} else {
			shooter.changeControlMode(TalonControlMode.PercentVbus);
			shooter.set(0);
			if(System.currentTimeMillis() > (time +2000))
				phi = 1;
		}
		SmartDashboard.putNumber("shooter speed", shooter.getSpeed());
		SmartDashboard.putNumber("shooter error", shooter.getSpeed()-shooter.getSetpoint());
		double motorOutput = shooter.getOutputVoltage() / shooter.getBusVoltage();
		_sb.append("\terr:");
		_sb.append(shooter.getClosedLoopError());
		_sb.append("\ttrg:");
		//        _sb.append(targetSpeed);

		/* prepare line to print */
		_sb.append("\tout:");
		_sb.append(motorOutput);
		_sb.append("\tspd:");
		_sb.append(shooter.getSpeed() );
		System.out.println(_sb.toString());
		if(++loops >= 10) {
			loops = 0;
			System.out.println(_sb.toString());
			_sb.setLength(0);
		}

		//pivot
//		if(Math.abs(joy.getRawAxis(2))>.05)
//			pivot.setSpeed(.1*joy.getRawAxis(2));
//		else
//			pivot.setSpeed(0);
//		else{
	//		theta=pivot.getPosition();

			if(joy.getPOV() == 90 && theta > -1)
				theta -= .005;
			else if(joy.getPOV() == 270 && theta < 1)
				theta += .005;
			theta = Math.max(0, Math.min(1, theta));
//		}
		SmartDashboard.putNumber("Pivot setpoint", theta);


		//hood
		phi = Math.max(0, Math.min(1, phi));
		SmartDashboard.putNumber("Setpoint Hood", phi);

		//roller rolls in
//		if(joy.getRawButton(Constants.LEFT_TRIGGER) && !prev){
//			toggle = !toggle;
//			if(toggleOut)
//				toggleOut = !toggleOut;
//		}
//		prev = joy.getRawButton(Constants.LEFT_TRIGGER);
//
//		//roller rolls out
//		if(joy.getRawButton(Constants.RIGHT_TRIGGER) && !prevOut){
//			toggleOut = !toggleOut;
//			if(toggle)
//				toggle = !toggle;
//		}
//		prevOut = joy.getRawButton(Constants.RIGHT_TRIGGER);

		if(joy.getRawButton(Constants.LEFT_TRIGGER)){
			roller.set(-1);
		}else if(joy.getRawButton(Constants.RIGHT_TRIGGER))
			roller.set(1);
		else if(Math.abs(-joy.getRawAxis(2)) >= .3){
			roller.set(1);
		}else{
	    roller.set(0);
	}
	}

}
