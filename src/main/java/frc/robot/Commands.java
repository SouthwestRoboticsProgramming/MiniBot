// Tells the code that this is part of the robot.
package frc.robot;

// More imports
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;

// Telling the code that this code is part of the robot
public class Commands extends Robot{
    @Override
	public void teleopPeriodic() {
   
// Processing inputs coming from the _gamepad   
    boolean GTFO = gamepad.getPOV() == 180;
    boolean turnLeft = gamepad.getPOV() == 270;
    boolean turnRight = gamepad.getPOV() == 90;
    boolean zoomy = gamepad.getPOV() ==0;
    double forward = -gamepad.getLeftY();
    double turn = -gamepad.getLeftX();	
    boolean slow = gamepad.getRawButton(2);

// Tells the controller to use a Deadband to avoid drift.
    forward = Deadband(forward);
    turn = Deadband(turn);
   
// Tells the robot to multiply the values by .25 if a button is pressed.
    if (slow) {
        forward *= 0.25;
        turn *= 0.25;
    }
// Sets the robot to use arcade drive this is code from CTRE
    _leftMaster.set(ControlMode.PercentOutput, forward, DemandType.ArbitraryFeedForward, +turn);
    _rightMaster.set(ControlMode.PercentOutput, forward, DemandType.ArbitraryFeedForward, -turn);

// Telling the robot what to do based on if a button is pressed.
    if (turnLeft) {
        _leftMaster.set(1);
        _rightMaster.set(-1);
    }
    if (turnRight) {
        _leftMaster.set(-1);
        _rightMaster.set(1);
    }
    if (zoomy) {
        _leftMaster.set(1);
        _rightMaster.set(1);
    }	
    if (GTFO) {
        _leftMaster.set(-1);
        _rightMaster.set(-1);
    }
   
}


// Sets a Deadband on the robot to prevent stick drift, change the values as needed.
double Deadband(double value) {
    /* Upper deadband */
    if (value >= +0.1) 
        return value;
    
    /* Lower deadband */
    if (value <= -0.1)
        return value;
    
    /* Outside deadband */
    return 0;

}
}  


