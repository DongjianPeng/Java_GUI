/*
 * Copyright (c) 2018. Murphy
 */

package cn.murphypen.Java_GUI.Unit5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyWindow extends JFrame implements ActionListener {

    private final int HEIGHT = 400;
    private final int WIDTH = 800;

    final JButton btnRed = new JButton("Red");
    final JButton btnGreen = new JButton("Green");

    public MyWindow() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().add(btnGreen);
        getContentPane().add(btnRed);
        btnRed.addActionListener(this);
        btnGreen.addActionListener(this);
        btnRed.setMnemonic('A');
        btnGreen.setMnemonic('B');
        setSize(WIDTH, HEIGHT);
        setLayout(new FlowLayout());
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Container contentPane = getContentPane();
        if (e.getActionCommand().equalsIgnoreCase("red")) {
            contentPane.setBackground(Color.RED);
        } else if (e.getActionCommand().equalsIgnoreCase("green")) {
            contentPane.setBackground(Color.GREEN);
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            MyWindow mw = new MyWindow();
        });
    }
}
