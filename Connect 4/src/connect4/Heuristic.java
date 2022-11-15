package connect4;

public class Heuristic {
	private static final char agent = 'Y';
	private static final char user = 'R';
	private static final char empty = '.';

	public int calcHeuristic(char[][] board) {
		int score = 0;
		score += connect4(board, agent) * 100;
		score -= connect4(board, user) * 100;
		score += connect3(board, agent) * 20;
		score -= connect3(board, user) * 20;
		score += connect2(board, agent) * 5;
		score -= connect2(board, user) * 5;
		return score;
	}

	public int connect4(char[][] board, char piece) {
		int score = 0;

		// horizontal
		for (int i = 0; i < Connect4.rows; i++)
			for (int j = 0; j < Connect4.columns - 3; j++)
				if (board[i][j] == piece && board[i][j + 1] == piece && board[i][j + 2] == piece && board[i][j + 3] == piece)
					score++;

		// vertical
		for (int i = 0; i < Connect4.rows - 3; i++)
			for (int j = 0; j < Connect4.columns; j++)
				if (board[i][j] == piece && board[i + 1][j] == piece && board[i + 2][j] == piece && board[i + 3][j] == piece)
					score++;

		// negative diagonal
		for (int i = 3; i < Connect4.rows; i++)
			for (int j = 0; j < Connect4.columns - 3; j++)
				if (board[i][j] == piece && board[i - 1][j + 1] == piece && board[i - 2][j + 2] == piece && board[i - 3][j + 3] == piece)
					score++;

		// positive diagonal
		for (int i = 0; i < Connect4.rows - 3; i++)
			for (int j = 0; j < Connect4.columns - 3; j++)
				if (board[i][j] == piece && board[i + 1][j + 1] == piece && board[i + 2][j + 2] == piece && board[i + 3][j + 3] == piece)
					score++;

		return score;

	}

	private int connect3(char[][] board, char piece) {
		int score = 0;

		// horizontal
		for (int i = 0; i < Connect4.rows; i++) {
			for (int j = 0; j < Connect4.columns - 3; j++) {
				if (board[i][j] == empty && board[i][j + 1] == piece && board[i][j + 2] == piece && board[i][j + 3] == piece)
					score++;
				if (board[i][j] == piece && board[i][j + 1] == empty && board[i][j + 2] == piece && board[i][j + 3] == piece)
					score++;
				if (board[i][j] == piece && board[i][j + 1] == piece && board[i][j + 2] == empty && board[i][j + 3] == piece)
					score++;
				if (board[i][j] == piece && board[i][j + 1] == piece && board[i][j + 2] == piece && board[i][j + 3] == empty)
					score++;
			}
		}

		// vertical
		for (int i = 0; i < Connect4.rows - 3; i++) {
			for (int j = 0; j < Connect4.columns; j++) {
				if (board[i][j] == empty && board[i + 1][j] == piece && board[i + 2][j] == piece && board[i + 3][j] == piece)
					score++;
				if (board[i][j] == piece && board[i + 1][j] == empty && board[i + 2][j] == piece && board[i + 3][j] == piece)
					score++;
				if (board[i][j] == piece && board[i + 1][j] == piece && board[i + 2][j] == empty && board[i + 3][j] == piece)
					score++;
				if (board[i][j] == piece && board[i + 1][j] == piece && board[i + 2][j] == piece && board[i + 3][j] == empty)
					score++;
			}
		}

		// negative diagonal
		for (int i = 3; i < Connect4.rows; i++) {
			for (int j = 0; j < Connect4.columns - 3; j++) {
				if (board[i][j] == empty && board[i - 1][j + 1] == piece && board[i - 2][j + 2] == piece && board[i - 3][j + 3] == piece)
					score++;
				if (board[i][j] == piece && board[i - 1][j + 1] == empty && board[i - 2][j + 2] == piece && board[i - 3][j + 3] == piece)
					score++;
				if (board[i][j] == piece && board[i - 1][j + 1] == piece && board[i - 2][j + 2] == empty && board[i - 3][j + 3] == piece)
					score++;
				if (board[i][j] == piece && board[i - 1][j + 1] == piece && board[i - 2][j + 2] == piece && board[i - 3][j + 3] == empty)
					score++;
			}
		}

		// positive diagonal
		for (int i = 0; i < Connect4.rows - 3; i++) {
			for (int j = 0; j < Connect4.columns - 3; j++) {
				if (board[i][j] == empty && board[i + 1][j + 1] == piece && board[i + 2][j + 2] == piece && board[i + 3][j + 3] == piece)
					score++;
				if (board[i][j] == piece && board[i + 1][j + 1] == empty && board[i + 2][j + 2] == piece && board[i + 3][j + 3] == piece)
					score++;
				if (board[i][j] == piece && board[i + 1][j + 1] == piece && board[i + 2][j + 2] == empty && board[i + 3][j + 3] == piece)
					score++;
				if (board[i][j] == piece && board[i + 1][j + 1] == piece && board[i + 2][j + 2] == piece && board[i + 3][j + 3] == empty)
					score++;
			}
		}
		return score;
	}

	private int connect2(char[][] board, char piece) {
		int score = 0;

		// horizontal
		for (int i = 0; i < Connect4.rows; i++) {
			for (int j = 0; j < Connect4.columns - 3; j++) {
				if (board[i][j] == empty && board[i][j + 1] == empty && board[i][j + 2] == piece && board[i][j + 3] == piece)
					score++;
				if (board[i][j] == piece && board[i][j + 1] == empty && board[i][j + 2] == piece && board[i][j + 3] == empty)
					score++;
				if (board[i][j] == piece && board[i][j + 1] == piece && board[i][j + 2] == empty && board[i][j + 3] == empty)
					score++;
				if (board[i][j] == empty && board[i][j + 1] == piece && board[i][j + 2] == piece && board[i][j + 3] == empty)
					score++;
				if (board[i][j] == empty && board[i][j + 1] == piece && board[i][j + 2] == empty && board[i][j + 3] == piece)
					score++;
				if (board[i][j] == piece && board[i][j + 1] == empty && board[i][j + 2] == empty && board[i][j + 3] == piece)
					score++;
			}
		}

		// vertical
		for (int i = 0; i < Connect4.rows - 3; i++) {
			for (int j = 0; j < Connect4.columns; j++) {
				if (board[i][j] == empty && board[i + 1][j] == empty && board[i + 2][j] == piece && board[i + 3][j] == piece)
					score++;
				if (board[i][j] == piece && board[i + 1][j] == empty && board[i + 2][j] == piece && board[i + 3][j] == empty)
					score++;
				if (board[i][j] == piece && board[i + 1][j] == piece && board[i + 2][j] == empty && board[i + 3][j] == empty)
					score++;
				if (board[i][j] == empty && board[i + 1][j] == piece && board[i + 2][j] == piece && board[i + 3][j] == empty)
					score++;
				if (board[i][j] == empty && board[i + 1][j] == piece && board[i + 2][j] == empty && board[i + 3][j] == piece)
					score++;
				if (board[i][j] == piece && board[i + 1][j] == empty && board[i + 2][j] == empty && board[i + 3][j] == piece)
					score++;
			}
		}

		// negative diagonal
		for (int i = 3; i < Connect4.rows; i++) {
			for (int j = 0; j < Connect4.columns - 3; j++) {
				if (board[i][j] == empty && board[i - 1][j + 1] == empty && board[i - 2][j + 2] == piece && board[i - 3][j + 3] == piece)
					score++;
				if (board[i][j] == piece && board[i - 1][j + 1] == empty && board[i - 2][j + 2] == piece && board[i - 3][j + 3] == empty)
					score++;
				if (board[i][j] == piece && board[i - 1][j + 1] == piece && board[i - 2][j + 2] == empty && board[i - 3][j + 3] == empty)
					score++;
				if (board[i][j] == empty && board[i - 1][j + 1] == piece && board[i - 2][j + 2] == piece && board[i - 3][j + 3] == empty)
					score++;
				if (board[i][j] == empty && board[i - 1][j + 1] == piece && board[i - 2][j + 2] == empty && board[i - 3][j + 3] == piece)
					score++;
				if (board[i][j] == piece && board[i - 1][j + 1] == empty && board[i - 2][j + 2] == empty && board[i - 3][j + 3] == piece)
					score++;
			}
		}

		// positive diagonal
		for (int i = 0; i < Connect4.rows - 3; i++) {
			for (int j = 0; j < Connect4.columns - 3; j++) {
				if (board[i][j] == empty && board[i + 1][j + 1] == empty && board[i + 2][j + 2] == piece && board[i + 3][j + 3] == piece)
					score++;
				if (board[i][j] == piece && board[i + 1][j + 1] == empty && board[i + 2][j + 2] == piece && board[i + 3][j + 3] == empty)
					score++;
				if (board[i][j] == piece && board[i + 1][j + 1] == piece && board[i + 2][j + 2] == empty && board[i + 3][j + 3] == empty)
					score++;
				if (board[i][j] == empty && board[i + 1][j + 1] == piece && board[i + 2][j + 2] == piece && board[i + 3][j + 3] == empty)
					score++;
				if (board[i][j] == empty && board[i + 1][j + 1] == piece && board[i + 2][j + 2] == empty && board[i + 3][j + 3] == piece)
					score++;
				if (board[i][j] == piece && board[i + 1][j + 1] == empty && board[i + 2][j + 2] == empty && board[i + 3][j + 3] == piece)
					score++;
			}
		}
		return score;
	}
}
