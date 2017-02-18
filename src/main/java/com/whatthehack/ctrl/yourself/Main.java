package com.whatthehack.ctrl.yourself;

import com.whatthehack.ctrl.yourself.comms.Client;
import com.whatthehack.ctrl.yourself.helpers.CommsHelper;
import com.whatthehack.ctrl.yourself.comms.Server;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.json.simple.parser.ParseException;

/**
 *
 */
public class Main extends JFrame {

    /**
     *
     */
    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                //new NativeHookDemo();
                new Server(CommsHelper.getPort());
                try {
                    //Thread.sleep(500);
                    Client client = new Client(InetAddress.getLocalHost().getHostAddress(), CommsHelper.getPort(), "User1");
                    Client client2 = new Client(InetAddress.getLocalHost().getHostAddress(), CommsHelper.getPort(), "User2");
                    Thread.sleep(100); //Required...
                    client.sendMessage("Hola");
                    //Thread.sleep(5000);
                    client.sendMessage("Hola");
                    client.sendMessage("Hola");
                    client2.sendMessage("A todos");
                    client.sendMessage("Hola");
                    client.sendMessage("Hola");
                    client.sendMessage("Hola");

                    //Client client2 = new Client(InetAddress.getLocalHost().getHostAddress(), CommsHelper.getPort(), "User2");
                } catch (UnknownHostException | InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        System.in.read();
    }
}
