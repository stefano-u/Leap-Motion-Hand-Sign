package com.bigboys.main;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.Frame;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Controller controller = new Controller();
        LeapListener listener = new LeapListener();
        
        controller.addListener(listener);
        
        System.out.println("Using hand signs, please do \"I LOVE YOU\"");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
         
        controller.removeListener(listener);
    }
    
}
