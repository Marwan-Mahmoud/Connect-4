package connect4;

public class MinMaxPruning extends IMinMax {

	private Pair maximize(Connect4 s, int deep, int alpha, int beta) {
		// full board state
		if (s.isTerminal())
			return new Pair(null, heuristic.connect4(s.getBoard(), 'Y'));
		// leaf state
		if (deep == 0) {
			int temp = heuristic.calcHeuristic(s.getBoard());
			if (depth <= 4)
				levels.get(depth - deep).put(s.getBoard(), temp);
			return new Pair(null, heuristic.calcHeuristic(s.getBoard()));

		}

		int maxUtility = Integer.MIN_VALUE;
		Connect4 maxChild = null;
		for (Connect4 child : s.getNeighbors()) {
			numExpandedNodes++;
			Pair p = minimize(child, deep - 1, alpha, beta);
			if (p.getUtility() > maxUtility) {
				maxChild = child;
				maxUtility = p.getUtility();
			}
			if (maxUtility >= beta)
				break;
			if (maxUtility > alpha)
				alpha = maxUtility;
		}
		if (depth <= 4)
			levels.get(depth - deep).put(s.getBoard(), maxUtility);
		return new Pair(maxChild, maxUtility);
	}

	private Pair minimize(Connect4 s, int deep, int alpha, int beta) {
		// full board state
		if (s.isTerminal())
			return new Pair(null, heuristic.connect4(s.getBoard(), 'Y'));

		// leaf state
		if (deep == 0) {
			int temp = heuristic.calcHeuristic(s.getBoard());
			if (depth <= 4)
				levels.get(depth - deep).put(s.getBoard(), temp);
			return new Pair(null, heuristic.calcHeuristic(s.getBoard()));
		}
		int minUtility = Integer.MAX_VALUE;
		Connect4 minChild = null;
		for (Connect4 child : s.getNeighbors()) {
			numExpandedNodes++;
			Pair p = maximize(child, deep - 1, alpha, beta);
			if (p.getUtility() < minUtility) {
				minChild = child;
				minUtility = p.getUtility();
			}
			if (minUtility <= alpha)
				break;
			if (minUtility < beta)
				beta = minUtility;
		}
		if (depth <= 4)
			levels.get(depth - deep).put(s.getBoard(), minUtility);
		return new Pair(minChild, minUtility);
	}

	@Override
	public Connect4 aiDecision(Connect4 s) {
		initializeLevels();

		long start = System.currentTimeMillis();
		Connect4 maxChild = maximize(s, depth, Integer.MIN_VALUE, Integer.MAX_VALUE).getChild();
		long end = System.currentTimeMillis();
		print(levels, depth);
		numExpandedNodes = 0;
		System.out.println("Time = " + (end - start) + " ms");
		maxChild.setUserScore(heuristic.connect4(maxChild.getBoard(), 'R'));
		maxChild.setAgentScore(heuristic.connect4(maxChild.getBoard(), 'Y'));
		return maxChild;
	}
}
