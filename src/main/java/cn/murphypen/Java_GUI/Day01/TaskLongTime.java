/**
 * STARPOST CONFIDENTIAL
 * _____________________
 * 
 * [2014] - [2018] StarPost Supply Chain Management Co. (Shenzhen) Ltd. 
 * All Rights Reserved.
 * 
 * NOTICE: All information contained herein is, and remains the property of
 * StarPost Supply Chain Management Co. (Shenzhen) Ltd. and its suppliers, if
 * any. The intellectual and technical concepts contained herein are proprietary
 * to StarPost Supply Chain Management Co. (Shenzhen) Ltd. and its suppliers and
 * may be covered by China and Foreign Patents, patents in process, and are
 * protected by trade secret or copyright law. Dissemination of this information
 * or reproduction of this material is strictly forbidden unless prior written
 * permission is obtained from StarPost Supply Chain Management Co. (Shenzhen)
 * Ltd.
 *
 */
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
