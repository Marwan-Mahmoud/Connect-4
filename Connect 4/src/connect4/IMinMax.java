package connect4;

import java.util.LinkedHashMap;
import java.util.List;

public abstract class IMinMax {
	protected int depth = 4;

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getDepth() {
		return depth;
	}

	public abstract Connect4 aiDecision(Connect4 s);

	public void printLevels(List<LinkedHashMap<char[][],Integer>> levels,int depth) {
		if (depth <= 4) {
			for (int i = 0; i <= depth; i++) {
				for (int k = 0; k < 6; k++) {
					for (char[][] board : levels.get(i).keySet()) {
						System.out.print(levels.get(i).get(board));
						for (int j = 0; j < 7; j++)
							System.out.print(board[k][j] + " ");

					}
					System.out.println();
				}
				System.out.println();
				//System.out.println();

			}
		}
	}

}
