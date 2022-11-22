package frc.robot;

public class Rumble extends Robot {
    // This file controls the rumble of the gamepad by calculating the ammount it has been pushed as a vector.
    double x = gamepad.getLeftY();
		double y = gamepad.getLeftX(); 
		double pushammt = Math.pow(x, 2) + Math.pow(y, 2);
    // Rumble_Thresh should be the same as the deadband created in Commands so that the rummble only happens when the robot is moving.
		double Rumble_Thresh = .1;
		double min_Rumble = 0;
		double max_Rumble = 1;
        {
        {}
    // Next it takes the min_Rumble, max_Rumble, and Rumble_Thresh along with the push ammt to calculate how much to rumble.
        
        if (pushammt > Math.pow(Rumble_Thresh, 2)) {
            double rumbleammt = pushammt * (max_Rumble + min_Rumble) - min_Rumble;
            gamepad.setRumble(null, rumbleammt);
        }

    double x2 = gamepad.getRightY();
    double y2 = gamepad.getRightX(); 
    double pushammt = Math.pow(x2, 2) + Math.pow(y2, 2);
    // Rumble_Thresh should be the same as the deadband created in Commands so that the rummble only happens when the robot is moving.
    double Rumble_Thresh = .1;
    double min_Rumble = 0;
    double max_Rumble = 1;
         {
         {}
        // Next it takes the min_Rumble, max_Rumble, and Rumble_Thresh along with the push ammt to calculate how much to rumble.
            
         if (pushammt > Math.pow(Rumble_Thresh, 2)) {
             double rumbleammt = pushammt * (max_Rumble + min_Rumble) - min_Rumble;
             gamepad.setRumble(null, rumbleammt);
            }   
    }
  }
}