package gui;

import connect4.Connect4;

public class Main {
	public static void main(String[] args) {
		Connect4 connect4 = new Connect4();
		Controller controller = new Controller();
		MyFrame frame = new MyFrame(controller);
		connect4.setController(controller);
		controller.setConnect4(connect4);
		controller.setPanel(frame.getPanel());
	}
}
