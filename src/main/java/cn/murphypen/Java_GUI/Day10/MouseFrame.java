package cn.murphypen.Java_GUI.Day10;

import javax.swing.*;

public class MouseFrame extends JFrame
{
    public MouseFrame()
    {
        add(new MouseComponent());
        pack();
    }
}