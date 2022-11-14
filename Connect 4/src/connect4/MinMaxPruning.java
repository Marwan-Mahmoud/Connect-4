package connect4;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class MinMaxPruning extends IMinMax {
	Heuristic h = new Heuristic();
	int numOfPlays = 1;
	int numOfNode = 0;
	List<LinkedHashMap<char[][], Integer>> levels;


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
			numOfNode++;
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
		levels.get(depth - deep).put(s.getBoard(), maxUtility);
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
			numOfNode++;
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
		levels.get(depth - deep).put(s.getBoard(), minUtility);
		return new Pair(minChild, minUtility);
	}

	@Override
	public Connect4 aiDecision(Connect4 s) {
		levels =  new ArrayList<>();
		for(int i=0; i<depth + 1; i++){
			levels.add(new LinkedHashMap<>());
		}

		Long start = System.currentTimeMillis();
		Connect4 maxChild = maximize(s, depth, Integer.MIN_VALUE, Integer.MAX_VALUE).getChild();
		long end = System.currentTimeMillis();
		System.out.println(numOfPlays++);
		System.out.println("Time = "+(end-start)+" ms");
		System.out.println("Number of node = "+numOfNode);
		numOfNode = 0;
		printLevels(levels,depth);
		maxChild.setUserScore(h.connect4(maxChild.getBoard(), 'R'));
		maxChild.setAgentScore(h.connect4(maxChild.getBoard(), 'Y'));
		return maxChild;
	}
}
