package cn.murphypen.Java_GUI.Day10;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.34 2015-06-12
 * @author Cay Horstmann
 */
public class MouseTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(() -> {
            JFrame frame = new MouseFrame();
            frame.setTitle("MouseTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}