
package frc.robot;
//importing the files from first and CTRE needed to control the robot, some are unused and are commented out.
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;


public class Robot extends TimedRobot {
	// Declaring the hardware and controllers a joystick is present but currently unused.
	WPI_TalonSRX _leftMaster = new WPI_TalonSRX(2);
	WPI_TalonSRX _rightMaster = new WPI_TalonSRX(1);
	XboxController gamepad = new XboxController(0);
	Joystick gamepad2 = new Joystick(1);

	private static final int PCM_CAM_ID = 37;
	private final Compressor compressor = new Compressor(PCM_CAM_ID, PneumaticsModuleType.CTREPCM);
	private final Solenoid solenoid = new Solenoid(PCM_CAM_ID, PneumaticsModuleType.CTREPCM, 0);

	private boolean solenoidToggle = true;
	private boolean prevSolenoidButton = false;

	
	@Override
	public void teleopInit(){
		/* Ensure motor output is neutral during init */
		_leftMaster.set(ControlMode.PercentOutput, 0);
		_rightMaster.set(ControlMode.PercentOutput, 0);

		/* Factory Default all hardware to prevent unexpected behaviour */
		_leftMaster.configFactoryDefault();
		_rightMaster.configFactoryDefault();
		
		/* Set Neutral mode */
		_leftMaster.setNeutralMode(NeutralMode.Brake);
		_rightMaster.setNeutralMode(NeutralMode.Brake);
		
		// One motor must be inverted otherwise it will just do donuts.
		_leftMaster.setInverted(false);
		_rightMaster.setInverted(true);
		
	}
{
	// Sends a message to the Riolog saying if the compressor is on or not.
		System.out.println("Compressor status: " + compressor.enabled());
		
	// Setting the button on the xbox controller to be a toggle.
		boolean solenoidButton = gamepad.getRawButton(1);
		
		if (solenoidButton && !prevSolenoidButton)
			solenoidToggle = !solenoidToggle;
		prevSolenoidButton = solenoidButton;

		solenoid.set(solenoidToggle);
		

		gamepad.setRumble(null, 0);
	
	}

}