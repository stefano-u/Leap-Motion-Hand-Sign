package com.bigboys.main;

import com.leapmotion.leap.*;
import javax.swing.ImageIcon;

public class LeapListener extends Listener{
    // Fingers for "I LOVE YOU"
    private static boolean loveIndexGood = false;
    private static boolean loveMiddleGood = false;
    private static boolean lovePinkyGood = false;
    private static boolean loveRingGood = false;
    private static boolean loveThumbGood = false;
    
    // Fingers for "OK"
    private static boolean okIndexGood = false;
    private static boolean okMiddleGood = false;
    private static boolean okPinkyGood = false;
    private static boolean okRingGood = false;
    private static boolean okThumbGood = false;

    public void onFrame(Controller controller) {
        
        Frame frame = controller.frame();
        
        for (Finger finger : frame.fingers()) {
            
            // z <= 0 means pointing up
            // z > 0 means pointing down
            if (finger.type().equals(Finger.Type.TYPE_INDEX)){
                if (finger.direction().getZ() <= 0) {
                    loveIndexGood = true;
                    okIndexGood = true;
                } else {
                    loveIndexGood = false;
                    okIndexGood = false;
                }
            }
            
            if (finger.type().equals(Finger.Type.TYPE_MIDDLE)) {
                if (finger.direction().getZ() > 0) {
                    loveMiddleGood = true;
                    okMiddleGood = true;
                } else {
                    loveMiddleGood = false;
                    okMiddleGood = false;
                }
            }
            
            if (finger.type().equals(Finger.Type.TYPE_PINKY)) {
                if (finger.direction().getZ() <= 0) {
                    lovePinkyGood = true;
                    okPinkyGood = false;
                } else {
                    lovePinkyGood = false;
                    okPinkyGood = true;
                } 
            }
            
            if (finger.type().equals(Finger.Type.TYPE_RING)) {
                if (finger.direction().getZ() > 0) {
                    loveRingGood = true;
                    okRingGood = true;
                } else {
                    loveRingGood = false;
                    okRingGood = false;
                }
            }
            
            if (finger.type().equals(Finger.Type.TYPE_THUMB)) {
                if (finger.direction().getZ() <= 0) {
                    loveThumbGood = true;
                    okThumbGood = true;
                } else {
                    loveThumbGood = false;
                    okThumbGood = false;
                }
            }
            
                     
            
        }
        //System.out.println(indexGood + ", " + middleGood + ", " + pinkyGood + ", " + ringGood + ", " + thumbGood);
        
        if (loveIndexGood && loveMiddleGood && lovePinkyGood && loveRingGood && loveThumbGood) {
            NewJFrame.img.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/i-love-you-gesture.png")));
            NewJFrame.signLabel.setText("I love you.");
            NewJFrame.signLabel.setVisible(true);
            NewJFrame.img.setVisible(true);
            speak("I love you");
            fingerFalse();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            NewJFrame.signLabel.setVisible(false);
            NewJFrame.img.setVisible(false);
        } else if (okIndexGood && okMiddleGood && okPinkyGood && okRingGood && okThumbGood){
            NewJFrame.img.setIcon(new ImageIcon(getClass().getClassLoader().getResource("img/ok.png")));
            NewJFrame.signLabel.setText("I understand.");
            NewJFrame.signLabel.setVisible(true);
            NewJFrame.img.setVisible(true);
            speak("I understand");
            fingerFalse();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            NewJFrame.signLabel.setVisible(false);
            NewJFrame.img.setVisible(false);
        } else {
            NewJFrame.signLabel.setVisible(false);
            NewJFrame.img.setVisible(false);
            
        }   
    }
    
    private static void speak(String phrase) {
        System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
        String text = phrase;
        TTS t = new TTS("kevin16");
        t.speak(text);
    }
    
    private static void fingerFalse(){
        loveIndexGood = false;
        loveMiddleGood = false;
        lovePinkyGood = false;
        loveRingGood = false;
        loveThumbGood = false;
        okIndexGood = false;
        okMiddleGood = false;
        okPinkyGood = false;
        okRingGood = false;
        okThumbGood = false;
    }
}
