/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comms;

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

/**
 *
 * @author rmendes
 */
public class Client extends Thread {

    private short socket_port;
    private String server_ip;
    private DatagramSocket socket = null;
    Socket clientSocket;

    public Client(String server_ip, short port) {
        super();
        this.socket_port = port;
        this.server_ip = server_ip;
        start();
    }

    @Override
    public void run() {
        try {
            //System.out.println("server_ip=" + server_ip + " port = " + socket_port);
            clientSocket = new Socket(server_ip, socket_port);
            new ReadStreamThread(clientSocket);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendMessage() {
        try {
            CommsHelper.sendMessage(clientSocket, "BluetrickPT");
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    private class WriteStreamThread extends Thread {
//
//        public WriteStreamThread(Socket clientSocket) throws IOException {
//            DataOutputStream outToServer = new DataOutputStream(
//                    new DataOutputStream(clientSocket.getOutputStream()));
//
//
//            outToServer.
//        }
//    }
    private class ReadStreamThread extends Thread {

        BufferedReader inFromServer;

        public ReadStreamThread(Socket clientSocket) throws IOException {
            inFromServer = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream(), "UTF-16"));

            start();
        }

        public void run() {
            while (true) {
                try {
                    System.out.println(inFromServer.readLine());
                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
