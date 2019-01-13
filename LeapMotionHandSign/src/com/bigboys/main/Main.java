package com.bigboys.main;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Finger;
import com.leapmotion.leap.Frame;
import java.awt.Color;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        NewJFrame frame = new NewJFrame();
        NewJFrame.signLabel.setVisible(false);
        NewJFrame.img.setVisible(false);
        frame.getContentPane().setBackground(Color.decode("#FFAB40"));
        frame.setVisible(true);
        
        Controller controller = new Controller();
        LeapListener listener = new LeapListener();
        
        controller.addListener(listener);
        
        
        System.out.println("Begin Communicating");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
                
         
        controller.removeListener(listener);
    }
    
}
