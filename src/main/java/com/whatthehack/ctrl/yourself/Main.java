package com.whatthehack.ctrl.yourself;

import com.whatthehack.ctrl.yourself.comms.Client;
import com.whatthehack.ctrl.yourself.helpers.CommsHelper;
import com.whatthehack.ctrl.yourself.comms.Server;
import com.whatthehack.ctrl.yourself.game.GameManager;
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

        GameManager gameManager = new GameManager();
        startGUI(gameManager);

//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                //new NativeHookDemo();
//                new Server(CommsHelper.getPort());
//                try {
//                    //Thread.sleep(500);
//                    Client client = new Client(InetAddress.getLocalHost().getHostAddress(), CommsHelper.getPort(), "User1");
//                    Client client2 = new Client(InetAddress.getLocalHost().getHostAddress(), CommsHelper.getPort(), "User2");
//                    Thread.sleep(100); //Required...
//                    client.sendMessage("Hola");
//                    //Thread.sleep(5000);
//                    client.sendMessage("Hola");
//                    client.sendMessage("Hola");
//                    client2.sendMessage("A todos");
//                    client.sendMessage("Hola");
//                    client.sendMessage("Hola");
//                    client.sendMessage("Hola");
//
//                    //Client client2 = new Client(InetAddress.getLocalHost().getHostAddress(), CommsHelper.getPort(), "User2");
//                } catch (UnknownHostException | InterruptedException ex) {
//                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IOException ex) {
//                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//
//        System.in.read();
    }

    public static void startGUI(GameManager gameManager) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Swing_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Swing_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Swing_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Swing_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Swing_GUI(gameManager).setVisible(false);
            }
        });
    }
}
