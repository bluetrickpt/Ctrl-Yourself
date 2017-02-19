/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whatthehack.ctrl.yourself.game;

import com.whatthehack.ctrl.yourself.comms.Client;
import com.whatthehack.ctrl.yourself.comms.Message;
import com.whatthehack.ctrl.yourself.comms.Server;
import com.whatthehack.ctrl.yourself.helpers.FilesHelper;
import java.io.IOException;
import java.util.ArrayList;
import com.whatthehack.ctrl.yourself.sound.SoundManager;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.DefaultListModel;

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

    private DefaultListModel users;
    private JList l_users;
    private JList chatWindow;
    private DefaultListModel messages;

    public GameManager() throws IOException {
        defaultChallenges.add(new Challenge("yellow", "Sing yellow from coldplay", "yellowKaraoke.wav"));
        defaultChallenges.add(new Challenge("yellow", "Sing toy", "toyKaraoke.wav"));
        activeChallenges = FilesHelper.readCSVFileChallenges(challengeFile, defaultChallenges);
        //System.out.println(activeChallenges);

        users = new DefaultListModel();
        messages = new DefaultListModel();
        l_users = new JList(users);
        chatWindow = new JList(messages);
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
        users.addElement(nickname);
        l_users.setModel(users);
    }

    public JList getL_users() {
        return l_users;
    }

    public void setL_users(JList l_users) {
        this.l_users = l_users;
    }

    public void updateChatWindow(String message) {

        //message = "<html>normal <b>bold</b> normal</html>";
        chatWindow.setFont(chatWindow.getFont().deriveFont(Font.PLAIN));
        messages.addElement(message);
        chatWindow.setModel(messages);

    }

    public void setChatWindow(JList l_messages) {
        this.chatWindow = l_messages;
    }
}
