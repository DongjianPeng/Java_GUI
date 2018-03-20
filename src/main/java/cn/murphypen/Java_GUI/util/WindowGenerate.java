package cn.murphypen.Java_GUI.util;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author dongjianpeng
 */
public class WindowGenerate {

    private static String windowTitle = "Title";
    private static int windowHeight = 400;
    private static int windowWidth = 800;

    private static LayoutManager layoutManager;

    public static void setLayout(LayoutManager layoutManager) {
        WindowGenerate.layoutManager = layoutManager;
    }


    public static void run(JFrame j) {
        if (j == null) {
            try {
                j = j.getClass().newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        Component[] c = null;
        run(j, windowTitle, windowHeight, windowWidth, c);
    }

    public static void run(final JFrame j, final Component... component) {
        run(j, windowTitle, windowHeight, windowWidth, component);
    }

    public static void run(final JFrame j, final String title, final int height, final int width) {
        Component[] c = null;
        run(j, title, height, width, c);
    }

    public static void run(final JFrame j, final String title, final int height, final int width,
                           final Component... component) {
        EventQueue.invokeLater(() -> {
            if (layoutManager != null) {
                j.setLayout(layoutManager);
            }
            j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            j.setTitle(title);
            j.setLocation(100, 100);
            j.setSize(width, height);
            j.setVisible(true);
            if (component != null && component.length > 0) {
                for (Component c : component) {
                    j.add(c);
                }
            }
        });
    }
}
