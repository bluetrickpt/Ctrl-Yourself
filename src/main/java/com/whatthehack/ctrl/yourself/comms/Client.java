/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whatthehack.ctrl.yourself.comms;

import com.whatthehack.ctrl.yourself.game.GameManager;
import com.whatthehack.ctrl.yourself.helpers.CommsHelper;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import org.json.simple.parser.ParseException;

/**
 *
 * @author rmendes
 */
public class Client extends Thread {

    private short socket_port;
    private String server_ip;
    private DatagramSocket socket = null;
    private String nickname = "";
    private Socket clientSocket;
    private GameManager gameManager;

    public Client(String server_ip, short port, String nickname, GameManager gameManager) {
        super();
        this.socket_port = port;
        this.server_ip = server_ip;
        this.nickname = nickname;
        this.gameManager = gameManager;
        start();
    }

    @Override
    public void run() {
        try {
            //System.out.println("server_ip=" + server_ip + " port = " + socket_port);
            clientSocket = new Socket(server_ip, socket_port);
            sendMessage("", Message.SYSTEM_MESSAGE);//send empty msg so that server adds user
            new ReadStreamThread(clientSocket);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendMessage(String contents, int code) {
        try {
            CommsHelper.sendMessage(
                    clientSocket, new Message(getNickname(), contents, code
                    ));
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    private class ReadStreamThread extends Thread {

        private Socket socket;

        public ReadStreamThread(Socket socket) {
            this.socket = socket;
            start();
        }

        public void run() {
            while (true) {
                try {
                    //System.out.println(CommsHelper.receiveMessage(socket).toString());
                    Message receivedMessage = CommsHelper.receiveMessage(socket);
                    gameManager.updateChatWindow(Message.handleNewMessage(receivedMessage, gameManager));
                } catch (ParseException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
