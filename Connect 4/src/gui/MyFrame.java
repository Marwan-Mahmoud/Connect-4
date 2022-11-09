package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame {

	private JFrame frame;
	private JPanel panel;

	public MyFrame() {
		frame = new JFrame("Connect 4");
		panel = new MyPanel();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame();
	}
}
