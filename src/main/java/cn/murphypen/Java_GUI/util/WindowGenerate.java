package cn.murphypen.Java_GUI.util;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author dongjianpeng
 *
 */
public class WindowGenerate {

	private static String windowTitle = "Title";
	private static int windowHeight = 400;
	private static int windowWidth = 800;

	private static LayoutManager layoutManager;

	public static void setLayout(LayoutManager layoutManager) {
		WindowGenerate.layoutManager = layoutManager;
	}

	public static void run(final JFrame j) {
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
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
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
			}
		});
	}
}
