package com.bigboys.main;

import com.leapmotion.leap.Controller;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        LeapListener listener = new LeapListener();
        
        controller.addListener(listener);
        
        // Keep this process running until Enter is pressed
        System.out.println("Press Enter to quit...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Remove the sample listener when done
        controller.removeListener(listener);
    }
    
}
