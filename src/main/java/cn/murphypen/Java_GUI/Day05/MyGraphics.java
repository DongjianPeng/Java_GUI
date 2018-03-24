/*
 * Copyright (c) 2018. MurphyPen
 */

package cn.murphypen.Java_GUI.Day05;


import cn.murphypen.Java_GUI.util.WindowGenerate;
import sun.font.Font2D;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

class Cavans extends JPanel {

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setBackground(Color.CYAN);
        g.setPaint(Color.MAGENTA);
        Font font2 = new Font("Consolas", Font.BOLD, 14);

        g.setFont(font2);
        g.drawString("Cavans", 0, 10);

        Rectangle2D rectangle2D = new Rectangle2D.Float(0f, 10f, 120f, 100f);
        g.setPaint(Color.RED);
        g.draw(rectangle2D);

        Ellipse2D ellipse2D = new Ellipse2D.Float(0f, 10f, 120f, 100f);
        g.setPaint(SystemColor.desktop.brighter().brighter());
        g.fill(ellipse2D);


        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        final String[] allFonts = graphicsEnvironment.getAvailableFontFamilyNames();
        for (String font : allFonts) {
            //System.out.println(font);
        }

        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();


        System.out.println(this.getClass().getResource("/").getPath());
        ImageIcon imageIcon = new ImageIcon("th.jpg");
        System.out.println(imageIcon.getIconHeight());

        Image image = defaultToolkit.getImage("C:\\Code\\eclipse_oxygen\\Java_GUI\\src\\main\\resources\\th.jpg");

        g.drawImage(image, 50, 50, null);
    }
}

class Drawing extends JFrame {
    public Drawing() throws HeadlessException {
        final Cavans cavans = new Cavans();
        cavans.setForeground(Color.PINK);
        add(cavans);
        pack();
    }
}

public class MyGraphics {
    public static void main(String[] args) {
        WindowGenerate.run(new Drawing());
    }
}
