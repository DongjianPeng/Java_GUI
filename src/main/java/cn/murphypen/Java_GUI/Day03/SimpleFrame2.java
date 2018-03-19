/*
 * Copyright (c) 2018. MurphyPen
 */

package cn.murphypen.Java_GUI.Day03;

import cn.murphypen.Java_GUI.util.WindowGenerate;

import javax.swing.*;
import java.awt.*;

class MyFrame2 extends JComponent {
    public MyFrame2() {
    }

    @Override
    protected void printComponent(Graphics g) {
        g.drawString("sss",10,10);
    }
}

public class SimpleFrame2 {
    public static void main(String[] args) {
    }
}
