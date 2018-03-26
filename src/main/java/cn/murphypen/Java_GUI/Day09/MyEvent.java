/*
 * Copyright (c) 2018. MurphyPen
 */

package cn.murphypen.Java_GUI.Day09;

import cn.murphypen.Java_GUI.util.WindowGenerate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


class MyFrame extends JFrame {


    class MyColorAction extends AbstractAction {

        public MyColorAction(String name, Color color) {
            putValue(Action.NAME, name);
            putValue(Action.SHORT_DESCRIPTION,name);
            putValue("color", color);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Swap Click");
            Color color = (Color)getValue("color");
            getContentPane().setBackground(color);

        }
    }

    public MyFrame() throws HeadlessException {
        JButton button1 = new JButton(new MyColorAction("RED", Color.RED));
        add(button1);
        JButton button2 = new JButton(new MyColorAction("GREEN", Color.GREEN));
        add(button2);
        JButton button3 = new JButton(new MyColorAction("BLUE", Color.BLUE));
        add(button3);

        KeyStroke key = KeyStroke.getKeyStroke("A");


    }
}

public class MyEvent {
    public static void main(String[] args) {
        WindowGenerate.run(new MyFrame());
    }

}
