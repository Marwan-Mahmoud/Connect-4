package connect4;

public class MinMaxPruning implements IMinMax {
	Heuristic h = new Heuristic();

	private Pair maximize(Connect4 s, int deep, int alpha, int beta) {
		if (deep == 0)
			return new Pair(null, h.calcHeuristic(s.getBoard()));

		int maxUtility = Integer.MIN_VALUE;
		Connect4 maxChild = null;
		for (Connect4 child : s.getNeighbors()) {
			Pair p = minimize(child, deep - 1, alpha, beta);
			if (p.getUtility() > maxUtility) {
				maxChild = p.getChild();
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
		if (deep == 0)
			return new Pair(null, h.calcHeuristic(s.getBoard()));

		int minUtility = Integer.MAX_VALUE;
		Connect4 minChild = null;
		for (Connect4 child : s.getNeighbors()) {
			Pair p = minimize(child, deep - 1, alpha, beta);
			if (p.getUtility() < minUtility) {
				minChild = p.getChild();
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
		Connect4 maxChild = maximize(s, 3, Integer.MIN_VALUE, Integer.MAX_VALUE).getChild();
		return maxChild;
	}
}
