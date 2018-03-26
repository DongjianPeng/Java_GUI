package cn.murphypen.Java_GUI.Day08;

import cn.murphypen.Java_GUI.util.WindowGenerate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;


class MyFrame extends JFrame {

    private JPanel buttonPanel;

    class MyColorAction extends AbstractAction {


        public MyColorAction(String name, Color color) {
           if(Color.BLUE.equals(color)){
               super.setEnabled(false);
           }
            putValue(Action.NAME, name);
            putValue(Action.SHORT_DESCRIPTION, name);
            putValue("color", color);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Swap Click");
            Color color = (Color) getValue("color");
            getContentPane().setBackground(color);

            if (buttonPanel != null) {
                buttonPanel.setBackground(color);
            }
        }
    }


    public MyFrame() throws HeadlessException {
        buttonPanel = new JPanel();

        MyColorAction red = new MyColorAction("RED", Color.RED);
        JButton button1 = new JButton(red);
        buttonPanel.add(button1);
        MyColorAction green = new MyColorAction("GREEN", Color.GREEN);
        JButton button2 = new JButton(green);
        buttonPanel.add(button2);
        MyColorAction blue = new MyColorAction("BLUE", Color.BLUE);
        JButton button3 = new JButton(blue);
        buttonPanel.add(button3);


        add(buttonPanel);
        InputMap inputMap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        ActionMap actionMap = buttonPanel.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("A"),"red");
        inputMap.put(KeyStroke.getKeyStroke("B"),"green");
        inputMap.put(KeyStroke.getKeyStroke("C"),"blue");

        actionMap.put("red",red);
        actionMap.put("green",green);
        actionMap.put("blue",blue);

    }
}

public class MyEvent {
    public static void main(String[] args) {
        WindowGenerate.run(new MyFrame());
    }

}
