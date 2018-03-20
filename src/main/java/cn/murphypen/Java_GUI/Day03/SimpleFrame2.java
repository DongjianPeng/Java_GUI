/*
 * Copyright (c) 2018. MurphyPen
 */

package cn.murphypen.Java_GUI.Day03;

import cn.murphypen.Java_GUI.util.WindowGenerate;
import com.sun.javaws.util.JfxHelper;

import javax.swing.*;
import java.awt.*;

class NotHelloWorldComponent extends JPanel {

    private Dimension dimension = null;



    @Override
    public void paintComponent(Graphics graphics) {
        dimension = getSize();

        System.out.println(dimension.getHeight());
        System.out.println(dimension.getWidth());
        Graphics2D g = (Graphics2D) graphics;
        g.drawLine(10,10,50,50);




    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 200);
    }
}

class MyFrame2 extends JFrame {
    public MyFrame2() throws HeadlessException {
        add(new NotHelloWorldComponent());
        pack();
    }
}

public class SimpleFrame2 {
    public static void main(String[] args) {
        WindowGenerate.run(new MyFrame2());
//        EventQueue.invokeLater(()->{
//            JFrame jFrame = new MyFrame2();
//            jFrame.setTitle("sfdsf");
//            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            jFrame.setVisible(true);
//
//        });
    }
}
