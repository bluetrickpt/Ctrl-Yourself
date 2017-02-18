/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comms;

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

/**
 *
 */
public class Server extends Thread {

    private HashMap<Socket, String> clientSockets2Nicknames;
    private ServerSocket acceptClientSocket;

    public Server(short port) {
        super();
        clientSockets2Nicknames = new HashMap<Socket, String>();
        start();
    }

    @Override
    public void run() {
        try {
            acceptClientSocket = new ServerSocket(CommsHelper.getPort());

            while (true) { //TODO: Condição paragem
                System.out.println("Starting listening");
                Socket clientSocket = acceptClientSocket.accept();
                clientSockets2Nicknames.put(clientSocket, "");
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
            System.out.println("Client connected");
            try {
                BufferedReader inFromServer = new BufferedReader(
                        new InputStreamReader(clientSocket.getInputStream(), "UTF-16"));

                //System.out.println("Server got: " + inFromServer.readLine());
                String welcome_string = CommsHelper.NEW_CLIENT_MESSAGE;
                String client_nickname = inFromServer.readLine();
                clientSockets2Nicknames.replace(clientSocket, client_nickname);
                //System.out.println(clientSockets2Nicknames.get(clientSocket));

                new Broadcast(clientSockets2Nicknames, welcome_string); //"Broadcast" welcome message
                //Esperar por mensagem no socket em "ciclo infinito"
                //Ao receber mensage, faz "brocaste"
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private class Broadcast extends Thread {

        private HashMap<Socket, String> targets;
        String message;

        public Broadcast(HashMap<Socket, String> targets, String message) {
            this.targets = targets;
            this.message = message;
            start();
        }

        public void run() {
            Iterator it = targets.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                try {
                    CommsHelper.sendMessage((Socket) pair.getKey(),
                            (String) pair.getValue() + ": " + message);
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
