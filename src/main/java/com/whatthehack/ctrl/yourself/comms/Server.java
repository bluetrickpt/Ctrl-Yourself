/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.whatthehack.ctrl.yourself.comms;

import com.whatthehack.ctrl.yourself.game.GameManager;
import com.whatthehack.ctrl.yourself.helpers.CommsHelper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.parser.ParseException;

/**
 *
 */
public class Server extends Thread {

    private HashMap<Socket, String> clientSockets2Nicknames;
    private ServerSocket acceptClientSocket;
    private GameManager gameManager;

    public Server(GameManager gameManager, short port) {
        super();
        clientSockets2Nicknames = new HashMap<Socket, String>();
        this.gameManager = gameManager;
        start();
    }

    @Override
    public void run() {
        try {
            acceptClientSocket = new ServerSocket(CommsHelper.getPort());

            while (true) { //TODO: Condição paragem
                //System.out.println("Starting listening");
                Socket clientSocket = acceptClientSocket.accept();
                //clientSockets2Nicknames.put(clientSocket, "");
                new ClientHandleThread(clientSocket);
            }

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private class ClientHandleThread extends Thread {

        private Socket clientSocket;

        public ClientHandleThread(Socket clientSocket) {
            super();
            this.clientSocket = clientSocket;
            start();
        }

        @Override
        public void run() {
            try {
                //System.out.println("Client connected");

                //System.out.println("Server got: " + inFromServer.readLine());
                Message clientMsg = CommsHelper.receiveMessage(clientSocket);
                //System.out.print("received " + clientMsg);
                String clientNick = clientMsg.getNickname();
                clientSockets2Nicknames.put(clientSocket, clientNick);
                //System.out.println(clientSockets2Nicknames.get(clientSocket));
                String welcomeString = Message.getWelcomeString(clientNick);
                //"Broadcast" welcome message
                new Broadcast(clientSockets2Nicknames,
                        new Message(clientNick, welcomeString, Message.NEW_MEMBER_MESSAGE));

                //Send users list
                //String usersString = gameManageretL_users().get
                String usersString = gameManager.getActiveUsersNicknames();
                if (usersString != null && usersString.length() > 0) {
                    CommsHelper.sendMessage(clientSocket,
                            new Message(clientNick, usersString, Message.UPDATE_USER_LIST_MESSAGE));
                }

                while (true) {
                    Message gotMessage = CommsHelper.receiveMessage(clientSocket);
                    if (gotMessage.getCode() == Message.USER_LEAVING_MESSAGE) {
                        gameManager.removeUserFromList(gotMessage.getNickname());
                        usersString = gameManager.getActiveUsersNicknames();
                        clientSockets2Nicknames.remove(clientSocket);
                        clientSocket.close();
                        new Broadcast(clientSockets2Nicknames, new Message(clientNick, "", Message.USER_LEAVING_MESSAGE));
                        new Broadcast(clientSockets2Nicknames, new Message("", usersString, Message.UPDATE_USER_LIST_MESSAGE));
                    } else {
                        new Broadcast(clientSockets2Nicknames, gotMessage);
                    }

                }
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public void handleServerClosing() {
        new Broadcast(clientSockets2Nicknames,
                new Message("", Message.serverClosingString(), Message.SERVER_CLOSING_MESSAGE));
    }

    private class Broadcast extends Thread {

        private HashMap<Socket, String> targets;
        Message toSendMessage;

        public Broadcast(HashMap<Socket, String> targets, Message message) {
            this.targets = targets;
            this.toSendMessage = message;

            if (Message.UPDATE_USER_LIST_MESSAGE == message.getCode()) {
                System.out.println("Here");
            }

            start();
        }

        public void run() {
            //System.out.println("Broadcasting: " + toSendMessage.toJSONString());
            Iterator it = targets.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                try {
                    CommsHelper.sendMessage((Socket) pair.getKey(), toSendMessage);
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
