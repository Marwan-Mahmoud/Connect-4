package gui;

import connect4.Connect4;
import connect4.IMinMax;
import connect4.MinMax;
import connect4.MinMaxPruning;

public class Main {
	public static void main(String[] args) {
		Connect4 connect4 = new Connect4();
		Controller controller = new Controller();
		MyFrame frame = new MyFrame(controller);
		IMinMax minMax = new MinMaxPruning();
		connect4.setController(controller);
		controller.setConnect4(connect4);
		controller.setPanel(frame.getPanel());
		controller.setMinMax(minMax);
	}
}
