/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whatthehack.ctrl.yourself.game;

import com.whatthehack.ctrl.yourself.comms.Client;
import com.whatthehack.ctrl.yourself.comms.Server;
import com.whatthehack.ctrl.yourself.helpers.FilesHelper;
import java.io.IOException;
import java.util.ArrayList;
import com.whatthehack.ctrl.yourself.sound.SoundManager;
import javax.swing.JTextArea;

/**
 *
 */
public class GameManager {

    public String challengeFile = "challenges.csv";
    public static ArrayList<Challenge> defaultChallenges = new ArrayList<>();
    public static ArrayList<Challenge> activeChallenges = new ArrayList<>();
    private SoundManager soundManager;

    private String nickname;
    private Server server;
    private Client client;

    private ArrayList<String> users;
    private JTextArea ta_users;
    private JTextArea chatWindow;

    public GameManager() throws IOException {
        defaultChallenges.add(new Challenge("yellow", "Sing yellow from coldplay", "yellowKaraoke.wav"));
        defaultChallenges.add(new Challenge("yellow", "Sing toy", "toyKaraoke.wav"));
        activeChallenges = FilesHelper.readCSVFileChallenges(challengeFile, defaultChallenges);
        //System.out.println(activeChallenges);
        users = new ArrayList<String>();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addUser(String nickname) {
        users.add(nickname);
        getTa_users().setText(getTa_users().getText() + nickname + '\n');
    }

    /**
     * @return the ta_users
     */
    public JTextArea getTa_users() {
        return ta_users;
    }

    /**
     * @param ta_users the ta_users to set
     */
    public void setTa_users(JTextArea ta_users) {
        this.ta_users = ta_users;
    }

    public void updateChatWindow(String message) {
        chatWindow.setText(chatWindow.getText().concat(message + '\n'));
    }

    public void setChatWindow(JTextArea ta_messages) {
        this.chatWindow = ta_messages;
    }
}
