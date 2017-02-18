/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comms;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.Charset;
import org.json.simple.parser.ParseException;

/**
 *
 */
public class CommsHelper {

    private static short port = 4445;

    public static final String NEW_CLIENT_MESSAGE = "USER JOINED THE ROOM.";

    /**
     * @return the port
     */
    public static short getPort() {
        return port;
    }

    /**
     * @param aPort the port to set
     */
    public static void setPort(short aPort) {
        port = aPort;
    }

    public static void sendMessage(Socket socket, Message message) throws IOException {

        DataOutputStream outToServer = new DataOutputStream(
                new DataOutputStream(socket.getOutputStream()));
        outToServer.writeUTF(message.toJSONString());
        //System.out.println("sending: " + message.toJSONString());
    }

    public static Message receiveMessage(Socket socket) throws IOException, ParseException {
        DataInputStream inputReader = new DataInputStream(socket.getInputStream());
        String receivedMessage = inputReader.readUTF();
        //System.out.println("Received: " + receivedMessage);
        return new Message(receivedMessage);
    }

}
