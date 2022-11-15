package gui;

import java.awt.Image;

import javax.swing.ImageIcon;

import connect4.Connect4;
import connect4.Connect4.Turn;
import connect4.IMinMax;
import connect4.MinMax;
import connect4.MinMaxPruning;

public class Controller {

	public static final Image RED_CHIP = new ImageIcon("Assets/Red.png").getImage();
	public static final Image YELLOW_CHIP = new ImageIcon("Assets/Yellow.png").getImage();

	private Connect4 connect4;
	private MyPanel panel;
	private IMinMax minMax;

	public Controller(Connect4 connect4) {
		this.connect4 = connect4;
		minMax = new MinMax();
	}

	/**
	 * Put a chip in the specified column.
	 */
	public void putChip(int column) {
		if (connect4.getTurn() == Turn.Red)
			connect4.putChip(column);
	}

	// Map 2D board of characters into a 2D chip images
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
		if (connect4.getTurn() == Turn.Yellow)
			connect4.setState(minMax.aiDecision(connect4));
	}

	public void setPanel(MyPanel panel) {
		this.panel = panel;
	}

	public void noPruning() {
		minMax = new MinMax();
	}

	public void pruning() {
		minMax = new MinMaxPruning();
	}

	public void setDepth(int depth) {
		minMax.setDepth(depth);
	}

	public int getUserScore() {
		return connect4.getUserScore();
	}

	public int getAgentScore() {
		return connect4.getAgentScore();
	}
}
