package connect4;

public class MinMax extends IMinMax {
	Heuristic h = new Heuristic();

	private Pair maximize(Connect4 s, int deep) {
		// full board state
		if (s.isTerminal())
			return new Pair(null, h.connect4(s.getBoard(), 'Y'));
		// leaf state
		if (deep == 0)
			return new Pair(null, h.calcHeuristic(s.getBoard()));

		int maxUtility = Integer.MIN_VALUE;
		Connect4 maxChild = null;
		for (Connect4 child : s.getNeighbors()) {
			Pair p = minimize(child, deep - 1);
			if (p.getUtility() > maxUtility) {
				maxChild = child;
				maxUtility = p.getUtility();
			}
		}
		return new Pair(maxChild, maxUtility);
	}

	private Pair minimize(Connect4 s, int deep) {
		// full board state
		if (s.isTerminal())
			return new Pair(null, h.connect4(s.getBoard(), 'Y'));
		// leaf state
		if (deep == 0)
			return new Pair(null, h.calcHeuristic(s.getBoard()));

		int minUtility = Integer.MAX_VALUE;
		Connect4 minChild = null;
		for (Connect4 child : s.getNeighbors()) {
			Pair p = maximize(child, deep - 1);
			if (p.getUtility() < minUtility) {
				minChild = child;
				minUtility = p.getUtility();
			}
		}
		return new Pair(minChild, minUtility);
	}

	@Override
	public Connect4 aiDecision(Connect4 s) {
		Connect4 maxChild = maximize(s, depth).getChild();
		maxChild.setAgentScore(h.connect4(maxChild.getBoard(), 'R'));
		maxChild.setUserScore(h.connect4(maxChild.getBoard(), 'Y'));
		return maxChild;
	}
}
