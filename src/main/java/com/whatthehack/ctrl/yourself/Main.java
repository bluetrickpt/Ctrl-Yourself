// Initial useless comment
package com.whatthehack.ctrl.yourself;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NativeHookDemo();
            }
        });
    }
}
