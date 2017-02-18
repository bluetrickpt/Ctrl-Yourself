/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whatthehack.ctrl.yourself.game;

import com.whatthehack.ctrl.yourself.helpers.FilesHelper;
import java.io.IOException;
import java.util.ArrayList;
import com.whatthehack.ctrl.yourself.sound.SoundManager;

/**
 *
 */
public class GameManager {
    public String challengeFile = "challenges.csv";
    public static ArrayList<Challenge> defaultChallenges = new ArrayList<>();
    public static ArrayList<Challenge> activeChallenges =  new ArrayList<>();
    private SoundManager soundManager;

    
    public GameManager() throws IOException {
        defaultChallenges.add(new Challenge("yellow", "Sing yellow from coldplay",  "yellowKaraoke.wav"));
        defaultChallenges.add(new Challenge("yellow", "Sing toy", "toyKaraoke.wav"));
        activeChallenges = FilesHelper.readCSVFileChallenges(challengeFile,defaultChallenges);
        System.out.println(activeChallenges);

    }
}
