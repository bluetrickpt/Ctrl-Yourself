package com.whatthehack.ctrl.yourself;

import comms.Client;
import comms.CommsHelper;
import comms.Server;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

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
                    Client client = new Client(InetAddress.getLocalHost().getHostAddress(), CommsHelper.getPort());
                    Thread.sleep(1500);
                    client.sendMessage();

                    Client client2 = new Client(InetAddress.getLocalHost().getHostAddress(), CommsHelper.getPort());
                    Thread.sleep(500);
                    client2.sendMessage();
                } catch (UnknownHostException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        System.in.read();
    }
}
