package com.github.superjoy0502.HomeworkMachine;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileChooser extends JFrame implements ActionListener {

    BufferedImage img;
    Scan scanner = new Scan();

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Application.open) {
            JFileChooser fc = new JFileChooser();
            int i = fc.showOpenDialog(this);
            if (i == JFileChooser.APPROVE_OPTION) {
                File f = fc.getSelectedFile();
                String filepath = f.getPath();
                try {
                    img = ImageIO.read(new File(filepath));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        }
        if (e.getSource() == Application.nscan) {
            try {
                scanner.scanWithDialog();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
        if (e.getSource() == Application.nnscan) {
            try {
                scanner.scanWithoutDialog();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }

}
