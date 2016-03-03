package com.ay.isystem.main;

import com.ay.isystem.views.config.ConfigFrame;

/**
 *
 * @author Adeel rana
 */
public class RunConfig {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConfigFrame().setVisible(true);
            }
        });
    }

}
