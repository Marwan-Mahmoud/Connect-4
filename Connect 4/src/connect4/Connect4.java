package connect4;

import java.util.ArrayList;
import java.util.List;

import gui.Controller;

public class Connect4 {

	public static final int rows = 6;
	public static final int columns = 7;

	private char[][] board;
	private Turn turn;
	private int userScore;
	private int agentScore;
	private int[] indexOfNextChip;
	private Controller controller;

	public Connect4() {
		board = new char[rows][columns];
		turn = Turn.Red;
		userScore = 0;
		agentScore = 0;

		indexOfNextChip = new int[columns];
		for (int i = 0; i < indexOfNextChip.length; i++)
			indexOfNextChip[i] = 5;
	}

	public enum Turn {
		Red, Yellow;
	}

	public Connect4 putChip(int column) {
		int row = indexOfNextChip[column]--;
		if (row < 0)
			return null;

		char nextChip = turn == Turn.Red ? 'R' : 'Y';
		board[row][column] = nextChip;
		turn = switchTurn(turn);

		if (controller != null)
			controller.setChips();
		return this;
	}

	public List<Connect4> getNeighbors() {
		List<Connect4> neighbors = new ArrayList<>();
		for (int column = 0; column < indexOfNextChip.length; column++) {
			int row = indexOfNextChip[column];
			if (row >= 0) {
				Connect4 neighbor = this.clone();
				neighbors.add(neighbor.putChip(column));
			}
		}
		return neighbors;
	}

	public char[][] getBoard() {
		return board;
	}

	public Turn getTurn() {
		return turn;
	}

	public Turn switchTurn(Turn turn) {
		return turn == Turn.Red ? Turn.Yellow : Turn.Red;
	}

	public int getUserScore() {
		return userScore;
	}

	public int getAgentScore() {
		return agentScore;
	}

	public int[] getColumns() {
		return indexOfNextChip;
	}

	public void setController(Controller controller) {
		this.controller = controller;
	}

	@Override
	protected Connect4 clone() {
		Connect4 connect4 = new Connect4();
		char[][] newBoard = new char[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++)
				newBoard[i][j] = board[i][j];
		}
		connect4.board = newBoard;
		connect4.turn = turn;
		connect4.indexOfNextChip = indexOfNextChip.clone();
		return connect4;
	}
}
