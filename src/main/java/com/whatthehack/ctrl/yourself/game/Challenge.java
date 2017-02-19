/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whatthehack.ctrl.yourself.game;

import com.whatthehack.ctrl.yourself.helpers.FilesHelper;
import com.whatthehack.ctrl.yourself.sound.SoundManager;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class Challenge {

    private String title;
    private String description;
    private String sound;

    public Challenge(String title, String description, String sound) {
        this.title = title;
        this.description = description;
        this.sound = sound;
        if (this.sound == null || this.sound.isEmpty()) {
            String[] allSounds = SoundManager.getSoundFiles();
            int randomInt = ThreadLocalRandom.current().nextInt(0, allSounds.length - 1 + 1);
            this.sound = allSounds[randomInt];
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public String toString() {
        return (title + " " + description + " " + sound);
    }

    public static void initChallengeList(ArrayList<Challenge> defaultChallenges) {
        defaultChallenges.add(new Challenge("Who's boss?", "You must ask the group for permission to use the bathroom for the rest of the night.", ""));
        defaultChallenges.add(new Challenge("Nagger.", "Circle around a person in the room 5 times each.", ""));
        defaultChallenges.add(new Challenge("Paula Ab-dumb.", "Make up a new dance and teach it to the group.", ""));
        defaultChallenges.add(new Challenge("Bad hair day.", "Pretend someone’s hair is your crush and ask it out.", ""));
        defaultChallenges.add(new Challenge("Pitman.", "Call up a friend and tell them how excited you are about armpits.", ""));
        defaultChallenges.add(new Challenge("Steve, I Wonder...", "Close your eyes and send a blind text to a random person.", ""));
        defaultChallenges.add(new Challenge("Fantasia.", "Go grab a broom and do your best tango.", ""));
        defaultChallenges.add(new Challenge("Right?", "Make up a story about the item to your right.", ""));
        defaultChallenges.add(new Challenge("Idol.", "Sing everything you say for the next 10 minutes.", ""));
        defaultChallenges.add(new Challenge("Air riff.", "Give a concert with your air guitar.", ""));
        // ^ 10
        defaultChallenges.add(new Challenge("Crime and punishment.", "Do pushups until someone hits a new key combo.", ""));
        defaultChallenges.add(new Challenge("Kanga-poo.", "Hop around the room.", ""));
        defaultChallenges.add(new Challenge("Who's a good boy?", "Be someone’s pet for the next 5 minutes.", ""));
        defaultChallenges.add(new Challenge("Egyptian.", "Walk sideways until someone hits a new key combo.", ""));
        defaultChallenges.add(new Challenge("Copy paste much?", "Stop, drop and give me 10 push-ups!", ""));
        defaultChallenges.add(new Challenge("House M.D.", "You've got a disease, and the only prescription is 20 push-ups! (Note: It's not lupus.)", ""));
        defaultChallenges.add(new Challenge("Mr. Grabby.", "Go and steal something from your coworker table!", ""));
        defaultChallenges.add(new Challenge("Michael Scott.", "Place a paper clip (any office equipment, really) on someone's head!", ""));
        defaultChallenges.add(new Challenge("I'm a creep.", "Creep up on someone and give them a scare! Legal notice: We take no responsibility on the ensuing violence.", ""));
        defaultChallenges.add(new Challenge("Dvorak’idding me?", "Change your keyboard layout to Dvorak for 10min.", ""));
        // ^ 20
        defaultChallenges.add(new Challenge("Usain in the Membrane!", "Run a couple of times around the office.", ""));
        defaultChallenges.add(new Challenge("Points for trying.", "Sing some a Happy Birthday, even if it’s not their birthday. Especially if it’s not their birthday.", ""));
        defaultChallenges.add(new Challenge("Leg stretch.", "Stretch while standing.", ""));
        defaultChallenges.add(new Challenge("Making enemies.", "Choose a target and turn their monitor off.", ""));
        defaultChallenges.add(new Challenge("Making more enemies.", "Choose a target and disable their mouse.", ""));
        defaultChallenges.add(new Challenge("Making more-er enemies.", "Choose a target and disable their keyboard. If they’re using a laptop, press their Caps Lock key.", ""));
        defaultChallenges.add(new Challenge("The Spy Who Came in from the Code.", "Choose a target and press a key combo on their keyboard.", ""));
        defaultChallenges.add(new Challenge("Tiny Rick!", "Play any song by Rick Astley through your speakers.", ""));
        defaultChallenges.add(new Challenge("Bob ‘Ninja’ Ross.", "Find a colleague who doesn’t lock their computer on their breaks and change their wallpaper to a Bob Ross painting.", ""));
        defaultChallenges.add(new Challenge("Get Out of Jail Free card.", "You go free this time.", ""));
        // ^ 30
        defaultChallenges.add(new Challenge("Ransomware.", "Steal an item from someone’s desk and make them press a key combo to have it back.", ""));
        defaultChallenges.add(new Challenge("Post-it back-it.", "Stick a post-it with a DJ Khaled quote in someone’s back.", ""));
        defaultChallenges.add(new Challenge("Slav it out.", "Squat until your knees give in.", ""));
        defaultChallenges.add(new Challenge("Beating a dead horse.", "You’re only allowed to return to your computer after completing the water bottle flip challenge. Dab for extra depression points.", ""));
        defaultChallenges.add(new Challenge("Mr. Policeman.", "Lock a colleague’s computer", ""));
        defaultChallenges.add(new Challenge("An apple a day.", "Make your next snack something healthy, like an apple.", ""));
        defaultChallenges.add(new Challenge("Minor inconvenience.", "Reboot your system.", ""));
        defaultChallenges.add(new Challenge("Chicken.", "Read a chapter from the Chicken Paper.", ""));
        defaultChallenges.add(new Challenge("Bing mistake.", "Set your default search engine to Bing.", ""));
        defaultChallenges.add(new Challenge("Iron abs.", "Show the world you can do Math, do 10 ABS()!-", ""));
        // ^ 40
        defaultChallenges.add(new Challenge("Facebook roulette", "Have a colleague send an awkward message to a random person in your Facebook friend list.", ""));
        defaultChallenges.add(new Challenge("What The Hack?", "Get a virutal cookie from the dev team!", ""));

    }
}
