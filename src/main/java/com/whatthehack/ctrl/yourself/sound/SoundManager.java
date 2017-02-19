/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whatthehack.ctrl.yourself.sound;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author rmendes
 */
public class SoundManager {

    private AudioInputStream audioIn;
    private boolean muted = false;

    private static final String[] soundFiles
            = {"cookie.wav", "copy.wav", "i_cant_believe.wav", "illuminati.wav",
                "laugh.wav", "nope.wav", "profanity.wav", "what_a_save.wav",
                "wrong.wav", "yeah_baby_yeah.wav"};

    public static String[] getSoundFiles() {
        return soundFiles;
    }

    public SoundManager(boolean muted) {
        AudioInputStream audioIn = null;
        this.muted = muted;
    }

    public void playSound(String soundFile) {
        if (!muted) {
            try {
                System.out.println("Starting");
                // Open an audio input stream.
                URL url = this.getClass().getClassLoader().getResource(soundFile);
                audioIn = AudioSystem.getAudioInputStream(url);
                // Get a sound clip resource.
                Clip clip = AudioSystem.getClip();
                // Open audio clip and load samples from the audio input stream.
                clip.open(audioIn);
                FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                System.out.println("min = " + volumeControl.getMinimum());
                System.out.println("max = " + volumeControl.getMaximum());
                clip.start();

            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(SoundManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SoundManager.class.getName()).log(Level.SEVERE, null, ex);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(SoundManager.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    audioIn.close();
                } catch (IOException ex) {
                    Logger.getLogger(SoundManager.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public boolean isMuted() {
        return muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

}
