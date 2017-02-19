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
import com.whatthehack.ctrl.yourself.helpers.KeyboardHandler;
import java.io.IOException;
import java.util.ArrayList;
import com.whatthehack.ctrl.yourself.sound.SoundManager;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

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
    private JList userListWindow;
    private JList chatWindow;
    private DefaultListModel messages;

    private KeyboardHandler keyboardHandler;

    public GameManager() throws IOException {
        Challenge.initChallengeList(defaultChallenges);
        activeChallenges = FilesHelper.readCSVFileChallenges(challengeFile, defaultChallenges);
        //System.out.println(activeChallenges);

        users = new DefaultListModel();
        messages = new DefaultListModel();
        userListWindow = new JList(users);
        chatWindow = new JList(messages);

        keyboardHandler = new KeyboardHandler(this);

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(keyboardHandler);
        // Get the logger for "org.jnativehook" and set the level to warning.
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);

        // Don't forget to disable the parent handlers.
        logger.setUseParentHandlers(false);
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
        userListWindow.setModel(users);
    }

    public JList getL_users() {
        return userListWindow;
    }

    public void setL_users(JList l_users) {
        this.userListWindow = l_users;
    }

    public void updateChatWindow(String message) {
        chatWindow.setFont(chatWindow.getFont().deriveFont(Font.PLAIN));
        messages.addElement(message);
        chatWindow.setModel(messages);
    }

    public void setChatWindow(JList l_messages) {
        this.chatWindow = l_messages;
    }

    public KeyboardHandler getKeyboardHandler() {
        return keyboardHandler;
    }
}
