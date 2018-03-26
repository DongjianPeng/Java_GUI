package cn.murphypen.Java_GUI.Day10;


import cn.murphypen.Java_GUI.util.WindowGenerate;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.util.List;


class MyPannel extends JComponent{
    private List<Rectangle2D> rectangle2DList = null;
    private Rectangle2D current = null;

    private MouseMotionAdapter mouseMotionAdapter = new MouseMotionAdapter() {
        @Override
        public void mouseDragged(java.awt.event.MouseEvent e) {
            System.out.println("mouseDragged");
            super.mouseDragged(e);
        }

        @Override
        public void mouseMoved(java.awt.event.MouseEvent e) {
            System.out.println("mouseMoved");
            super.mouseMoved(e);
        }
    };
    private MouseInputAdapter mouseInputAdapter = new MouseInputAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            System.out.println("mouseClicked");
            super.mouseClicked(e);
        }
    };

    public MyPannel() {
        addMouseListener(mouseInputAdapter);
        addMouseMotionListener(mouseMotionAdapter);
    }
}

class MyFrame extends JFrame {
    public MyFrame() throws HeadlessException {
        add(new MyPannel());
        pack();
    }
}

public class MyMouseEvent {
    public static void main(String[] args) {
        WindowGenerate.run(new MyFrame());
    }
}
