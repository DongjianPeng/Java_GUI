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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import cn.murphypen.Java_GUI.util.WindowGenerate;

/**
 * @author dongjianpeng
 *
 */
public class Popup extends JFrame {
	private JPopupMenu popup = new JPopupMenu();
	private JTextField t = new JTextField(10);

	public Popup() {
		setLayout(new FlowLayout());
		add(t);
		ActionListener al = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setText(((JMenuItem) e.getSource()).getText());
			}
		};
		JMenuItem m = new JMenuItem("Hither");
		m.addActionListener(al);
		popup.add(m);
		m = new JMenuItem("Yon");
		m.addActionListener(al);
		popup.add(m);
		m = new JMenuItem("Afar");
		m.addActionListener(al);
		popup.add(m);
		popup.addSeparator();
		m = new JMenuItem("Stay Here");
		m.addActionListener(al);
		popup.add(m);
		PopupListener pl = new PopupListener();
		addMouseListener(pl);
		t.addMouseListener(pl);
	}

	class PopupListener extends MouseAdapter {
		public void mousePressed(MouseEvent e) {
			maybeShowPopup(e);
		}

		public void mouseReleased(MouseEvent e) {
			maybeShowPopup(e);
		}

		private void maybeShowPopup(MouseEvent e) {
			if (e.isPopupTrigger())
				popup.show(e.getComponent(), e.getX(), e.getY());
		}
	}

	public static void main(String[] args) {
		WindowGenerate.run(new Popup());
	}
}