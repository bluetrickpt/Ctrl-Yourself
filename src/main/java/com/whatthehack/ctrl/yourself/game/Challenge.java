/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whatthehack.ctrl.yourself.game;

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
    public String toString(){
        return(title + " " + description + " " +  sound);
    }
    
    
    
    
    
}


