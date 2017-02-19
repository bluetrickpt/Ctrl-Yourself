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
                String welcomeString = CommsHelper.NEW_CLIENT_MESSAGE;

                Message clientMsg = CommsHelper.receiveMessage(clientSocket);

                String clientNick = clientMsg.getNickname();
                clientSockets2Nicknames.put(clientSocket, clientNick);
                gameManager.addUser(clientNick);
                //System.out.println(clientSockets2Nicknames.get(clientSocket));

                //"Broadcast" welcome message
                new Broadcast(clientSockets2Nicknames, new Message(clientNick, welcomeString));
                //Esperar por mensagem no socket em "ciclo infinito"
                //Ao receber mensage, faz "brocaste"
                while (true) {
                    new Broadcast(clientSockets2Nicknames, CommsHelper.receiveMessage(clientSocket));
                }
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class Broadcast extends Thread {

        private HashMap<Socket, String> targets;
        Message toSendMessage;

        public Broadcast(HashMap<Socket, String> targets, Message message) {
            this.targets = targets;
            this.toSendMessage = message;
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
