package connect4;

public class MinMax implements IMinMax {
	Heuristic h = new Heuristic();

	private Pair maximize(Connect4 s, int deep) {
		if (deep == 0)
			return new Pair(s, h.calcHeuristic(s.getBoard()));

		int maxUtility = Integer.MIN_VALUE;
		Connect4 maxChild = null;
		for (Connect4 child : s.getNeighbors()) {
			Pair p = minimize(child, deep - 1);
			if (p.getUtility() > maxUtility) {
				maxChild = p.getChild();
				maxUtility = p.getUtility();
			}
		}
		return new Pair(maxChild, maxUtility);
	}

	private Pair minimize(Connect4 s, int deep) {
		if (deep == 0)
			return new Pair(s, h.calcHeuristic(s.getBoard()));

		int minUtility = Integer.MAX_VALUE;
		Connect4 minChild = null;
		for (Connect4 child : s.getNeighbors()) {
			Pair p = minimize(child, deep - 1);
			if (p.getUtility() < minUtility) {
				minChild = p.getChild();
				minUtility = p.getUtility();
			}
		}
		return new Pair(minChild, minUtility);
	}

	@Override
	public Connect4 aiDecision(Connect4 s) {
		Connect4 maxChild = maximize(s, 1).getChild();
		return maxChild;
	}
}
