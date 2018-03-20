/*
 * Copyright (c) 2018. MurphyPen
 */

package cn.murphypen.Java_GUI.Day04;

import cn.murphypen.Java_GUI.util.WindowGenerate;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTextUI;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

class MyGraphics extends JPanel {

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.drawString("lksdhflsjhdofhoshpf", 10, 20);
        //drawing rectangle
        Rectangle2D rectangle2D = new Rectangle2D.Float(20f, 3.5f, 200f, 150f);
        g.draw(rectangle2D);
        //drawing ellipse
        Ellipse2D ellipse2D = new Ellipse2D.Float(20f, 3.5f, 200f, 150f);
        g.draw(ellipse2D);

        Ellipse2D ellipse2D2 = new Ellipse2D.Float();
        ellipse2D2.setFrameFromCenter(50,150,90,80);
        g.draw(ellipse2D2);
        Line2D line = new Line2D.Float(1.5f,45f,300,147f);
        g.draw(line);

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

class MyFrame4 extends JFrame {
    public MyFrame4() throws HeadlessException {
        add(new MyGraphics());
    }
}

public class TestGraphics {
    public static void main(String[] args) {
        WindowGenerate.run(new MyFrame4());
    }
}
