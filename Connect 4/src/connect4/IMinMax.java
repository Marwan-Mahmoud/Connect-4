package connect4;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public abstract class IMinMax {
	protected int depth = 4;
	protected int numPlays = 1;
	protected int numExpandedNodes = 0;
	protected Heuristic heuristic;
	protected List<LinkedHashMap<char[][], Integer>> levels;

	public IMinMax() {
		heuristic = new Heuristic();
	}

	public abstract Connect4 aiDecision(Connect4 s);

	protected void initializeLevels() {
		levels = new ArrayList<>();
		int d = Math.min(depth, 4);
		for (int i = 0; i < d + 1; i++)
			levels.add(new LinkedHashMap<>());
	}

	public void print(List<LinkedHashMap<char[][], Integer>> levels, int depth) {
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
			}
		}
		System.out.println(numPlays++);
		System.out.println("Number of expanded nodes = " + numExpandedNodes);
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
}
