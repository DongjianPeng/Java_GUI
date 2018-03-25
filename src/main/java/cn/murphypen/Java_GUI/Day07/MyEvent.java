package cn.murphypen.Java_GUI.Day07;


import cn.murphypen.Java_GUI.util.WindowGenerate;
import sun.swing.SwingUtilities2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeListener;


class MyMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        MyPaint paint = (MyPaint) e.getSource();
        Graphics graphics = paint.getGraphics();
        Graphics2D g = SwingUtilities2.getGraphics2D(graphics);
        g.drawString("Click", e.getX(), e.getY());
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());

    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());


    }
}

class MyMotion implements MouseMotionListener {

    @Override
    public void mouseDragged(MouseEvent e) {
        //按下移动
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}

class MyPaint extends JPanel {
    public MyPaint() {
        setBackground(Color.RED);
        addMouseListener(new MyMouseListener());
        addMouseMotionListener(new MyMotion());
    }

    @Override
    public void paint(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;


    }
}
class MyWindowAdapter extends WindowAdapter{
    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("icon");
        System.exit(0);
    }
}
class MyClick implements Action{

    @Override
    public Object getValue(String key) {
        return null;
    }

    @Override
    public void putValue(String key, Object value) {

    }

    @Override
    public void setEnabled(boolean b) {

    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click");

    }
}
class MyButton extends JButton{
    public MyButton() {
        addActionListener(new MyClick());
    }
}
class MyFrame extends JFrame implements WindowListener{

    public MyFrame() throws HeadlessException {
        MyPaint myPaint = new MyPaint();
        add(myPaint);
        add(new MyButton());
        addWindowListener(this);
        addWindowListener(new MyWindowAdapter());
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("windowActivated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}


public class MyEvent {
    public static void main(String[] args) {
        WindowGenerate.run(new MyFrame());
    }
}




class ColorStateMachine {
    private static Color color = Color.RED;

    public Color getColor() {
        if (color == null) {
            return color = Color.RED;
        }
        if (Color.RED.equals(color)) {
            return color = Color.GREEN;
        } else {
            return color = Color.BLUE;
        }
    }
}
