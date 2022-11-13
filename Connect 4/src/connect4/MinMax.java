package connect4;


import java.util.ArrayList;
import java.util.List;

public class MinMax extends IMinMax {
	Heuristic h = new Heuristic();
	int numOfPlays = 1;
	List<Integer> u = new ArrayList<>();



	private Pair maximize(Connect4 s, int deep, List<char[][]> min,List<char[][]> max) {
		// full board state
		if (s.isTerminal())
			return new Pair(null, h.connect4(s.getBoard(), 'Y'));
		// leaf state
		if (deep == 0)
			return new Pair(null, h.calcHeuristic(s.getBoard()));

		int maxUtility = Integer.MIN_VALUE;
		Connect4 maxChild = null;
		for (Connect4 child : s.getNeighbors()) {
			if(depth-deep<4)
			min.add(child.getBoard());
			Pair p = minimize(child, deep - 1,min,max);
			if (p.getUtility() > maxUtility) {
				maxChild = child;
				maxUtility = p.getUtility();
			}
			u.add(p.getUtility());
		}
		return new Pair(maxChild, maxUtility);
	}

	private Pair minimize(Connect4 s, int deep,List<char[][]> min,List<char[][]> max) {
		// full board state
		if (s.isTerminal())
			return new Pair(null, h.connect4(s.getBoard(), 'Y'));
		// leaf state
		if (deep == 0)
			return new Pair(null, h.calcHeuristic(s.getBoard()));

		int minUtility = Integer.MAX_VALUE;
		Connect4 minChild = null;
		for (Connect4 child : s.getNeighbors()) {
			if(depth-deep<4)
				max.add(child.getBoard());
			Pair p = maximize(child, deep - 1,min,max);
			if (p.getUtility() < minUtility) {
				minChild = child;
				minUtility = p.getUtility();
			}
		}

		return new Pair(minChild, minUtility);
	}

	@Override
	public Connect4 aiDecision(Connect4 s) {
		List<char[][]> min = new ArrayList<>();
		List<char[][]> max = new ArrayList<>();
		Connect4 maxChild = maximize(s, depth,min,max).getChild();
		System.out.println(u);
		int d = Math.min(depth,4);
		System.out.println(numOfPlays++);
		List<Integer> indexMin = firstDepthLoc(min);
		List<Integer> indexMax = firstDepthLoc(max);

		for(int i=1;i<=d;i++){
			if(i%2!=0) {
				printMin(min,i,indexMin);
			}
			else printMin(max,i,indexMax);
		}

		maxChild.setUserScore(h.connect4(maxChild.getBoard(), 'R'));
		maxChild.setAgentScore(h.connect4(maxChild.getBoard(), 'Y'));
		return maxChild;
	}
	private void printMin(List<char[][]> list,int depth,List<Integer> index){

			if(depth <=2)
			for (int i = 0; i < 6; i++) {
				for (int loc : index)
					print(list.get(loc), i);
				System.out.println();
			}

		if(depth>=3) {
				for (int i = 0; i < 6; i++) {
					for(int k=0;k<list.size();k++)
						if(!index.contains(k))
							print(list.get(k),i);
					System.out.println();
				}

			}
		System.out.println();
	}

	private int countPieces(char[][] a){
		int num = 0;
		for(int i = 0;i<a.length;i++)
			for (int j = 0;j<a[i].length;j++)
				if(a[i][j]!='.') num++;
		return num;
	}

	private List<Integer> firstDepthLoc(List<char[][]> list){
		if(list.size()!=0) {
			List<Integer> index = new ArrayList<>();
			int num = countPieces(list.get(0));
			for (int j = 0; j < list.size(); j++)
				if (num == countPieces(list.get(j)))
					index.add(j);

			return index;
		}
		return new ArrayList<>();
	}

private void print(char[][] mat,int i) {

	for (int j = 0; j < 7; j++)
		System.out.print((mat[i][j] + " "));

//		writer.write(Arrays.toString(mat[i]));
	System.out.print("	");

}

}
