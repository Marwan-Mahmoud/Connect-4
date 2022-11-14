package connect4;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class MinMax extends IMinMax {
	Heuristic h = new Heuristic();
	int numOfPlays = 1;
	int numOfNode = 0;
	List<LinkedHashMap<char[][], Integer>> levels;



	private Pair maximize(Connect4 s, int deep,List<LinkedHashMap<char[][], Integer>> levels) {
		// full board state
		if (s.isTerminal())
			return new Pair(null, h.connect4(s.getBoard(), 'Y'));
		// leaf state
		if (deep == 0) {
			int temp = h.calcHeuristic(s.getBoard());
			if(depth<=4)
			levels.get(depth - deep).put(s.getBoard(), temp);
			return new Pair(null, temp);
		}
		int maxUtility = Integer.MIN_VALUE;
		Connect4 maxChild = null;
		for (Connect4 child : s.getNeighbors()) {
			numOfNode++;
			Pair p = minimize(child, deep - 1, levels);
			if (p.getUtility() > maxUtility) {
				maxChild = child;
				maxUtility = p.getUtility();
			}
		}
		if(depth<=4)
		levels.get(depth - deep).put(s.getBoard(), maxUtility);
		return new Pair(maxChild, maxUtility);
	}

	private Pair minimize(Connect4 s, int deep,List<LinkedHashMap<char[][], Integer>> levels)  {
		// full board state
		if (s.isTerminal())
			return new Pair(null, h.connect4(s.getBoard(), 'Y'));
		// leaf state
		if (deep == 0) {
			int temp = h.calcHeuristic(s.getBoard());
			if(depth<=4)
			levels.get(depth - deep).put(s.getBoard(), temp);
			return new Pair(null, temp);
		}

		int minUtility = Integer.MAX_VALUE;
		Connect4 minChild = null;
		for (Connect4 child : s.getNeighbors()) {
			numOfNode++;
			Pair p = maximize(child, deep - 1,levels);
			if (p.getUtility() < minUtility) {
				minChild = child;
				minUtility = p.getUtility();
			}
		}
		if(depth<=4)
		levels.get(depth - deep).put(s.getBoard(), minUtility);
		return new Pair(minChild, minUtility);
	}

	@Override
	public Connect4 aiDecision(Connect4 s) {
		levels =  new ArrayList<>();
		int d = Math.min(depth,4);
		for(int i=0; i<d + 1; i++){
			levels.add(new LinkedHashMap<>());
		}

		long start = System.currentTimeMillis();
		Connect4 maxChild = maximize(s, depth,levels).getChild();
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
