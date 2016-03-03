/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ay.isystem.utililty;

import com.ay.isystem.controller.InventryController;
import com.ay.isystem.models.EntityBeans.Users;
import com.ay.isystem.views.panels.WelcomePanel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Adeel rana
 */
public class Global {

    public static InventryController CONTROLLER = new InventryController();
    public static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MMM-yyyy");
    public static Users LOGGED_USER = new Users();
    public static boolean progressState = false;
    private static JPanel mainPanel;
    private static JFrame mainFrame;

    public static JPanel getMainPanel() {
        return mainPanel;
    }

    public static void setMainPanel(JPanel mainPanel) {
        Global.mainPanel = mainPanel;
    }

    public static JFrame getMainFrame() {
        return mainFrame;
    }

    public static void setMainFrame(JFrame mainFrame) {
        Global.mainFrame = mainFrame;
    }

    public static void addPanel(JPanel panel, JPanel mainPanel) {
        mainPanel.removeAll();
        panel.setSize(mainPanel.getSize());
        mainPanel.add(panel);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    public static void addPanel(Class cls, JPanel mainPanel) {
        try {
            mainPanel.removeAll();
            JPanel panel = (JPanel) cls.newInstance();
            panel.setSize(mainPanel.getSize());
            mainPanel.add(panel);
            mainPanel.repaint();
            mainPanel.revalidate();
        } catch (InstantiationException | IllegalAccessException ex) {
            JOptionPane.showMessageDialog(mainPanel, ex.getMessage());
        }
    }

    public void addPanel(Class cls) {
        try {
            mainPanel.removeAll();
            JPanel panel = (JPanel) cls.newInstance();
            panel.setSize(mainPanel.getSize());
            mainPanel.add(panel);
            mainPanel.repaint();
            mainPanel.revalidate();
        } catch (InstantiationException | IllegalAccessException ex) {
            JOptionPane.showMessageDialog(mainPanel, ex.getMessage());
        }
    }

    public static <T> boolean addListToCombo(JComboBox c, ArrayList<T> li) {
        try {
            for (Object o : li) {
                c.addItem(o);
            }
        } catch (Exception e) {
        }

        return true;
    }

    public static void addToList(DefaultListModel li, Object val) {
        if (li.indexOf(val) == -1) {
            li.addElement(val);
        }
    }

    public static void removeFromList(DefaultListModel li, Object val) {
        if (li.indexOf(val) != -1) {
            li.removeElement(val);
        }
    }

    public static void goToMainScreen() {
        JPanel parent = getMainPanel();
        parent.removeAll();
        JPanel panel = new WelcomePanel(parent);
        panel.setSize(parent.getSize());
        parent.add(panel);
        parent.repaint();
        parent.revalidate();
    }

    public static void saveException(Exception e, boolean flag, String text) {
        if (flag) {
            JOptionPane.showMessageDialog(getMainPanel(), text + "\n---->" + e);
        }
        File folder = new File(getAppDir() + "Exceptions");
        int lastFile = 0;
        String name;
        if (folder.exists()) {
            name = folder.listFiles()[folder.listFiles().length - 1].getName().split("\\.")[0];
            lastFile = Integer.parseInt("" + name.charAt(name.length() - 1));
        } else {
            folder.mkdir();
        }
        try {
            FileWriter fw;
            try (StringWriter errors = new StringWriter()) {
                String content = errors.toString();
                File file = new File(getAppDir() + "Exceptions/exception" + (lastFile + 1) + ".txt");
                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }
                fw = new FileWriter(file.getAbsoluteFile());
                try (BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.write(content);
                    bw.close();
                }
                fw.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(getMainPanel(), ex);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(getMainPanel(), ex);
        }
    }

    public static String getAppDir() {
//        return System.getProperty("user.home").concat("/AppData/Roaming/Wiztech/OMS/").replace("\\", "/");
        return "";
    }

    public static void main(String[] args) throws URISyntaxException {
        System.out.println(("../../"+Global.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath()));
    }

}
