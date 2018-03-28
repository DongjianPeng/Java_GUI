package cn.murphypen.Java_GUI.Day10;


import com.google.common.collect.Lists;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.util.List;


class MyPannel extends JPanel {
    private List<Rectangle2D> rectangle2DList = Lists.newArrayList();
    private Rectangle2D current = null;
    private Dimension size = null;
    private final float side = 5f;

    private MouseMotionAdapter mouseMotionAdapter = new MouseMotionAdapter() {
        @Override
        public void mouseDragged(java.awt.event.MouseEvent e) {
            if (find(e.getPoint())) {
                current.setFrame(e.getX() - side, e.getY() - side, 2 * side, 2 * side);
                repaint();
            }
        }

        @Override
        public void mouseMoved(java.awt.event.MouseEvent e) {
            if (find(e.getPoint())) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            } else {
                setCursor(Cursor.getDefaultCursor());
            }
        }
    };
    class MyMouseInputAdapter extends MouseInputAdapter {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            if (1 == e.getClickCount()) {
                //单击
                if (!find(e.getPoint())) {
                    Rectangle2D.Float rectangle = new Rectangle2D.Float(e.getX() - side, e.getY() - side, 2 * side, 2 * side);
                    rectangle2DList.add(rectangle);
                    repaint();

                }
            } else if (2 == e.getClickCount()) {
                //双击
                if (find(e.getPoint())) {
                    rectangle2DList.remove(current);
                    repaint();
                }
            }

            System.out.println("mouseClicked");
            super.mouseClicked(e);
        }

    };

    private boolean find(Point point) {
        if (rectangle2DList != null) {
            current = rectangle2DList.stream().filter(r -> r.contains(point)).findFirst().orElse(null);
            return current != null;
        }
        return false;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // draw all squares
        for (Rectangle2D r : rectangle2DList)
            g2.draw(r);
    }

    public MyPannel(Dimension size) {
        this.size = size;
        addMouseListener(new MyMouseInputAdapter());
        addMouseMotionListener(mouseMotionAdapter);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(size);
    }
}
class MyFrame extends JFrame {
    public MyFrame() throws HeadlessException {
        add(new MyPannel(new Dimension(800, 400)));
        pack();
    }
}

public class MyMouseEvent {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MyFrame myFrame = new MyFrame();
            myFrame.setVisible(true);
            myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        });

    }
}
