package cn.murphypen.Java_GUI.Day06;


import cn.murphypen.Java_GUI.util.WindowGenerate;

import javax.swing.*;
import java.awt.*;

class MyDraw extends JPanel{

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.RED);
        g.drawString("This's not a String",10,10);

    }
}
class MyFrame extends JFrame{

    public MyFrame() throws HeadlessException {
        add(new MyDraw());
    }
}
public class MyGraphics2 {
    public static void main(String[] args) {
        WindowGenerate.run(new MyFrame());
    }
}
