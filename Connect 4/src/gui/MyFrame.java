package gui;

import javax.swing.JFrame;

public class MyFrame {

	private JFrame frame;
	private MyPanel panel;

	public MyFrame(Controller connect4) {
		frame = new JFrame("Connect 4");
		panel = new MyPanel(connect4);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public MyPanel getPanel() {
		return panel;
	}
}
