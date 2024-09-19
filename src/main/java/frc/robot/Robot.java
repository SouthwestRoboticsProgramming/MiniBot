package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
	private static final int DRIVER_CONTROLLER_ID = 0;

	private static final int LEFT_CAN_ID = 1;
	private static final int RIGHT_CAN_ID = 2;

	private final Joystick joystick = new Joystick(DRIVER_CONTROLLER_ID);

	// Drive motors
	private final TalonSRX leftDrive = new TalonSRX(LEFT_CAN_ID);
	private final TalonSRX rightDrive = new TalonSRX(RIGHT_CAN_ID);

	@Override
	public void robotInit() {
		// Initialize the robot

		leftDrive.setInverted(false);
		rightDrive.setInverted(true);
	}

	@Override
	public void teleopInit() {
		// Do things when robot is enabled
	}

	@Override
	public void teleopPeriodic() {
		// Do things periodically (50 times per second while enabled)

		double x = joystick.getX();
		double y = joystick.getY();

		// Make the joystick Y axis control the speed of the driving
		double driveSpeed = -y;

		double leftSpeed = driveSpeed;
		double rightSpeed = driveSpeed;

		leftDrive.set(ControlMode.PercentOutput, leftSpeed);
		rightDrive.set(ControlMode.PercentOutput, rightSpeed);
	}
}