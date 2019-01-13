package com.bigboys.main;

import com.leapmotion.leap.*;

public class LeapListener extends Listener{
    private static boolean indexGood = false;
    private static boolean middleGood = false;
    private static boolean pinkyGood = false;
    private static boolean ringGood = false;
    private static boolean thumbGood = false;

    public void onFrame(Controller controller) {
        
        Frame frame = controller.frame();
        
        for (Finger finger : frame.fingers()) {
            
            // z <= 0 means pointing up
            // z > 0 means pointing down
            if (finger.type().equals(Finger.Type.TYPE_INDEX)){
                if (finger.direction().getZ() <= 0) {
                    indexGood = true;
                } else {
                    indexGood = false;
                }
            }
            
            if (finger.type().equals(Finger.Type.TYPE_MIDDLE)) {
                if (finger.direction().getZ() > 0) {
                    middleGood = true;
                } else {
                    middleGood = false;
                }
            }
            
            if (finger.type().equals(Finger.Type.TYPE_PINKY)) {
                if (finger.direction().getZ() <= 0) {
                    pinkyGood = true;
                } else {
                    pinkyGood = false;
                } 
            }
            
            if (finger.type().equals(Finger.Type.TYPE_RING)) {
                if (finger.direction().getZ() > 0) {
                    ringGood = true;
                } else {
                    ringGood = false;
                }
            }
            
            if (finger.type().equals(Finger.Type.TYPE_THUMB)) {
                if (finger.direction().getZ() <= 0) {
                    thumbGood = true;
                } else {
                    thumbGood = false;
                }
            }
            
                     
            
        }
        //System.out.println(indexGood + ", " + middleGood + ", " + pinkyGood + ", " + ringGood + ", " + thumbGood);
        
        if (indexGood && middleGood && pinkyGood && ringGood && thumbGood) {
            NewJFrame.jLabel2.setText("Success!");
            System.out.println("I LOVE YOU is triggered");  
            controller.removeListener(this);
        }        
    }
}
