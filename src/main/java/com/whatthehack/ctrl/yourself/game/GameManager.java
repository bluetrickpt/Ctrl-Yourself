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
import java.util.Collections;
import java.awt.GraphicsEnvironment;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
    private boolean isMuted;

    //private ArrayList<String> users
    private DefaultListModel users;
    private JList userListWindow;
    private JList chatWindow;
    private DefaultListModel messages;
    private JDialog challengeDialog;
    private JLabel challengeTitle;
    private JLabel challengeDesc;
    private JButton sendButton;

    public void setSendButton(JButton sendButton) {
        this.sendButton = sendButton;
    }

    private JTextField inputMessageField;

    public void setInputMessageField(JTextField inputMessageField) {
        this.inputMessageField = inputMessageField;
    }

    private KeyboardHandler keyboardHandler;

    public GameManager() throws IOException {
        Challenge.initChallengeList(defaultChallenges);
        //activeChallenges = FilesHelper.readCSVFileChallenges(challengeFile, defaultChallenges);
        activeChallenges = defaultChallenges;
        //System.out.println(activeChallenges);

        users = new DefaultListModel();
        messages = new DefaultListModel();
        userListWindow = new JList(users);
        chatWindow = new JList(messages);
        soundManager = new SoundManager(false);
        keyboardHandler = new KeyboardHandler(this);
    }

    public void startHandlingKeyboard() {
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

    public String getActiveUsersNicknames() {
        ArrayList<String> activeUsers = Collections.list(users.elements());
        String toReturn = "";
        for (int i = 0; i < activeUsers.size(); ++i) {
            toReturn += (activeUsers.get(i));
            if (i < activeUsers.size() - 1) {
                toReturn += Message.USERS_DELIMITER;
            }
        }
        return toReturn;
    }

    public void disableMessages() {
        inputMessageField.setText("Server shutdown. You are disconnected. Please restart client to connect again.");
        inputMessageField.setEnabled(false);
        sendButton.setEnabled(false);
    }

    public void removeUserFromList(String nickname) {
        ArrayList<String> activeUsers = Collections.list(users.elements());
        System.out.println("Trying to remove " + nickname);
        for (int i = 0; i < activeUsers.size(); ++i) {
            System.out.println("active user = " + activeUsers.get(i));
            if (activeUsers.get(i).equals(nickname)) {
                users.remove(i);
                //userListWindow.setModel(users);
                System.out.println("removed user" + activeUsers.get(i));
                return;
            }
        }
    }

    public void setChallengeDialog(JDialog dialog) {
        this.challengeDialog = dialog;
    }

    public void setChallengeTitle(JLabel title) {
        this.challengeTitle = title;
    }

    public void setChallengeDesc(JLabel desc) {
        this.challengeDesc = desc;
    }

    public void setChallengePopup(JLabel title, JLabel desc, JDialog dialog) {
        setChallengeTitle(title);
        setChallengeDesc(desc);
        setChallengeDialog(dialog);
    }

    public void launchChallenge() {
        int currentChallenge = ThreadLocalRandom.current().nextInt(0, activeChallenges.size() - 1);
        Challenge newChallenge = activeChallenges.get(currentChallenge);
        this.challengeTitle.setText(newChallenge.getTitle());
        this.challengeDesc.setText(newChallenge.getDescription());
        this.challengeDialog.setVisible(true);
        this.challengeDialog.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
        System.out.println(newChallenge + "\n");

        soundManager.playSound(newChallenge.getSound());
        String challengeMessage = client.getNickname() + " got challenged to " + newChallenge.getDescription();
        client.sendMessage(challengeMessage, Message.CHALLENGE_MESSAGE);
    }

    public void setMute(boolean mute) {
        soundManager.setMuted(mute);
    }

    public void restartUsers() {
        users = new DefaultListModel();
        chatWindow.setModel(messages);
    }
}
