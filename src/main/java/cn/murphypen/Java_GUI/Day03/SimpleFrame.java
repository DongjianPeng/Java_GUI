/*
 * Copyright (c) 2018. MurphyPen
 */

package cn.murphypen.Java_GUI.Day03;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

class MyFrame extends JFrame {
    private final int DEFAULT_HIGHT = 200;
    private final int DEFUALT_WIDTH = 400;

    public MyFrame() throws HeadlessException {
        final Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        setSize(DEFAULT_HIGHT, DEFUALT_WIDTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(false);
        setBounds(0, 50, 300, 100);
        Image image = new BufferedImage(120, 50, BufferedImage.TYPE_INT_RGB);
        setIconImage(image);
        setLocationByPlatform(true);
        setVisible(true);
    }
}

public class SimpleFrame {
    static final MyFrame myFrame = new MyFrame();
    public static void main(String[] args) {
        EventQueue.invokeLater(SimpleFrame::run);
        EventQueue.invokeLater(SimpleFrame::run2);
    }

    private static void run() {
        int i = 700;
        while (i > 0) {
            i--;
            final Point location = myFrame.getLocation();
            final Point newLocation = new Point((int) location.getX() + 1, (int) location.getY() + 1);
            myFrame.setLocation(newLocation);
            try {
                TimeUnit.MILLISECONDS.sleep(5L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void run2() {
        int i = 700;
        while (i > 0) {
            i--;
            final Point location = myFrame.getLocation();
            final Point newLocation = new Point((int) location.getX() - 1, (int) location.getY() - 1);
            myFrame.setLocation(newLocation);
            try {
                TimeUnit.MILLISECONDS.sleep(20L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
