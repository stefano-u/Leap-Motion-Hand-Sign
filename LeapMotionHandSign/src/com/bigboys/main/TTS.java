package com.bigboys.main;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class TTS {
    private Voice voice;
    public TTS(String voiceName)
    {
        VoiceManager voiceManager = VoiceManager.getInstance();
        voice = voiceManager.getVoice(voiceName);
    }
    public void speak(String msg) {
        voice.allocate();
        voice.speak(msg);
        voice.deallocate();
    }
}
