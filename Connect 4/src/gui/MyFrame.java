package gui;

import javax.swing.JFrame;

import connect4.InitialWindow;

public class MyFrame {

	private JFrame frame;
	private MyPanel panel;

	public MyFrame(Controller controller) {
		frame = new JFrame("Connect 4");
		panel = new MyPanel(controller);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		new InitialWindow(controller);
	}

	public MyPanel getPanel() {
		return panel;
	}
}
