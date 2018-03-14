package cn.murphypen.Java_GUI.Day01;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import cn.murphypen.Java_GUI.util.WindowGenerate;

/**
 * @author dongjianpeng
 *
 */
class TaskLong extends JFrame {
	private static final long serialVersionUID = 1L;
	private JButton b1 = new JButton("b1"), b2 = new JButton("b2");

	public TaskLong() {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				b1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							TimeUnit.SECONDS.sleep(3);
						} catch (InterruptedException e1) {
							System.out.println("b1 InterruptedException");
							e1.printStackTrace();
						}
						System.out.println("b1 complete");
					}
				});
			}
		});
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				b2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Thread.currentThread().interrupt();
						System.out.println("b2 complete");
					}
				});
			}
		});
		add(b1);
		add(b2);
	}
}

public class TaskLongTime {
	public static void main(String[] args) {
		WindowGenerate.setLayout(new FlowLayout());
		WindowGenerate.run(new TaskLong());
	}
}
