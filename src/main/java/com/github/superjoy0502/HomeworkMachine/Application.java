package com.github.superjoy0502.HomeworkMachine;

import chrriis.dj.nativeswing.NativeComponentWrapper;
import chrriis.dj.nativeswing.NativeSwing;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;

import javax.swing.*;
import java.awt.*;

public class Application {

    public static JMenuItem open, nscan, nnscan;
    JFrame f;
    JMenuBar mb;
    JPanel west, fileRenderPanel, south;
    JMenu file;
    int multiplier = 300;
    private static JWebBrowser fileBrowser = new JWebBrowser();

    Application() {
        f = new JFrame("Homework Machine");
        mb = new JMenuBar();
        west = new JPanel();
        fileRenderPanel = new JPanel();
        south = new JPanel();

        west.setBackground(Color.green);
//        fileRenderPanel.setBackground(Color.yellow);
        south.setBackground(Color.blue);

        f.add(west, BorderLayout.WEST);
//        f.add(fileRenderPanel, BorderLayout.CENTER);
        f.add(south, BorderLayout.SOUTH);

        file = new JMenu("File");
        open = new JMenuItem("Open");
        open.addActionListener(new FileChooser());
        nscan = new JMenuItem("Scan with Dialog");
        nscan.addActionListener(new FileChooser());
        nnscan = new JMenuItem("Scan");
        nnscan.addActionListener(new FileChooser());
        file.add(open);
        file.add(nscan);
        file.add(nnscan);
        mb.add(file);

        fileBrowser.setBarsVisible(false);
        fileBrowser.setStatusBarVisible(false);
//        fileBrowser.setHTMLContent("Hello");
//        fileRenderPanel.add(fileBrowser);
        f.add(fileBrowser, BorderLayout.CENTER);

        f.setJMenuBar(mb);
        f.setSize(4 * multiplier, 3 * multiplier);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        NativeSwing.initialize();
        NativeInterface.open();
        setUIFont(new javax.swing.plaf.FontUIResource("Sans-Serif", Font.PLAIN, 12));
        new Application();
        NativeInterface.runEventPump();
    }

    public static void setUIFont(javax.swing.plaf.FontUIResource f) {
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put(key, f);
        }
    }

    public static void openPDF(String path){
        fileBrowser.navigate(path);
    }
}
