package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import connect4.IConnect4;
import connect4.MockConnect4;

public class MyFrame {

	private JFrame frame;
	private JPanel panel;

	public MyFrame(IConnect4 connect4) {
		frame = new JFrame("Connect 4");
		panel = new MyPanel(connect4);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame(new MockConnect4());
	}
}
