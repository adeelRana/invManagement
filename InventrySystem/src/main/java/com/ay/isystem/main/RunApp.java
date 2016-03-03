package com.ay.isystem.main;

import com.ay.isystem.views.main.MainFrame;

/**
 *
 * @author Adeel rana
 */
public class RunApp {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

}
