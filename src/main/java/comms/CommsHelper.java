/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comms;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

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

    public static void sendMessage(Socket socket, String message) throws IOException {
        if (!message.isEmpty()) {
            if (message.charAt(message.length() - 1) != '\n') {
                message += '\n';
            }
            DataOutputStream outToServer = new DataOutputStream(
                    new DataOutputStream(socket.getOutputStream()));
            outToServer.writeChars(message);
            //System.out.println(socket.getLocalAddress() + " sent: " + message);
        }
    }
}
