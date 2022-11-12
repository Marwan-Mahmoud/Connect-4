package gui;

import java.awt.Image;

import javax.swing.ImageIcon;

import connect4.Algorithm;
import connect4.Connect4;
import connect4.Connect4.Turn;
import connect4.MinMax;
import connect4.MinMaxPruning;

public class Controller {

	public static final Image RED_CHIP = new ImageIcon("Assets/Red.png").getImage();
	public static final Image YELLOW_CHIP = new ImageIcon("Assets/Yellow.png").getImage();

	private Connect4 connect4;
	private MyPanel panel;
	private MinMax minMax;

	public void putChip(int column) {
		if (connect4.getTurn() == Turn.Red)
			connect4.putChip(column);
	}

	public void setChips() {
		Image[][] chips = new Image[Connect4.rows][Connect4.columns];
		char[][] board = connect4.getBoard();
		for (int i = 0; i < Connect4.rows; i++) {
			for (int j = 0; j < Connect4.columns; j++) {
				if (board[i][j] == 'R')
					chips[i][j] = RED_CHIP;
				else if (board[i][j] == 'Y')
					chips[i][j] = YELLOW_CHIP;
			}
		}
		panel.setChips(chips);
		Algorithm algorithm = new MinMaxPruning();
		if (connect4.getTurn() == Turn.Yellow)
			connect4.setState(algorithm.aiDecision(connect4));
	}

	public void setConnect4(Connect4 connect4) {
		this.connect4 = connect4;
	}

	public void setPanel(MyPanel panel) {
		this.panel = panel;
	}
	
	public void setMinMax(MinMax minMax) {
		this.minMax = minMax;
	}
}
