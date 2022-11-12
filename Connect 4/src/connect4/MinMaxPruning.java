package connect4;

public class MinMaxPruning extends IMinMax {
	Heuristic h = new Heuristic();

	private Pair maximize(Connect4 s, int deep, int alpha, int beta) {
		// full board state
		if (s.isTerminal())
			return new Pair(null, h.connect4(s.getBoard(), 'Y'));
		// leaf state
		if (deep == 0)
			return new Pair(null, h.calcHeuristic(s.getBoard()));

		int maxUtility = Integer.MIN_VALUE;
		Connect4 maxChild = null;
		for (Connect4 child : s.getNeighbors()) {
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
		return new Pair(maxChild, maxUtility);
	}

	private Pair minimize(Connect4 s, int deep, int alpha, int beta) {
		// full board state
		if (s.isTerminal())
			return new Pair(null, h.connect4(s.getBoard(), 'Y'));

		// leaf state
		if (deep == 0)
			return new Pair(null, h.calcHeuristic(s.getBoard()));

		int minUtility = Integer.MAX_VALUE;
		Connect4 minChild = null;
		for (Connect4 child : s.getNeighbors()) {
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
		return new Pair(minChild, minUtility);
	}

	@Override
	public Connect4 aiDecision(Connect4 s) {
		Connect4 maxChild = maximize(s, depth, Integer.MIN_VALUE, Integer.MAX_VALUE).getChild();
		maxChild.setAgentScore(h.connect4(maxChild.getBoard(), 'R'));
		maxChild.setUserScore(h.connect4(maxChild.getBoard(), 'Y'));
		return maxChild;
	}
}
