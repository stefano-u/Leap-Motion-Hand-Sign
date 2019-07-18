package com.bigboys.main;

import com.leapmotion.leap.*;
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import com.sun.speech.freetts.en.us.CMUDiphoneVoice;
import com.sun.speech.freetts.en.us.CMULexicon;
import com.sun.speech.freetts.audio.JavaClipAudioPlayer;

public class LeapListener extends Listener{
    private static final String VOICENAME = "kevin";
    
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
            
            //remove listener so that sensor doesn't continue reading motion after successful signing
            controller.removeListener(this);
            
            //say the phrase out loud
            VoiceManager voiceMgr = VoiceManager.getInstance();
            //create voice and set lexicon
            Voice ttsVoice = voiceMgr.getVoice(VOICENAME);
            ttsVoice.setLexicon(new CMULexicon());
            //ttsVoice.setAudioPlayer(new JavaClipAudioPlayer());disable this because it takes away the voice
            //ttsVoice.setVolume(1);
            ttsVoice.allocate();//loads the voice
            /*System.out.println("Audio Player: " + ttsVoice.getAudioPlayer()
                                + ", Lexicon: " + ttsVoice.getLexicon()
                                + ", Volume: " + ttsVoice.getVolume()
                                + ", Voice: " + ttsVoice.getName());*/
            ttsVoice.speak("I LOVE YOU");
            ttsVoice.deallocate();//deallocate as soon as its done talking to avoid hogging resources
        }        
    }
}
