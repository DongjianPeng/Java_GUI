package cn.murphypen.Java_GUI;

import java.awt.*;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        final Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        final Dimension screenSize = defaultToolkit.getScreenSize();
        System.out.println(screenSize.getHeight());
        System.out.println(screenSize.getWidth());
    }
}
