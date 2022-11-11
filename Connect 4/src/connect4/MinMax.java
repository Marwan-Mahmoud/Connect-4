package connect4;

public class MinMax {
    private Pair maximize(Connect4 s, int deep) {
//        if(deep == 0)
//            return new Pair(null, calcHeuristic(s));

        int maxUtility = Integer.MIN_VALUE;
        Connect4 maxChild = null;
        for(Connect4 child : s.getNeighbors()){
            Pair p = minimize(child, deep - 1);
            if(p.getUtility() > maxUtility){
                maxChild = p.getChild();
                maxUtility = p.getUtility();
            }
        }
        return new Pair(maxChild, maxUtility);
    }

    private Pair minimize(Connect4 s, int deep) {
//        if(deep == 0)
//            return new Pair(null, calcHeuristic(s));

        int minUtility = Integer.MAX_VALUE;
        Connect4 minChild = null;
        for(Connect4 child : s.getNeighbors()){
            Pair p = minimize(child, deep - 1);
            if(p.getUtility() < minUtility){
                minChild = p.getChild();
                minUtility = p.getUtility();
            }
        }
        return new Pair(minChild, minUtility);
    }

    public Connect4 aiDecision(Connect4 s){
        Connect4 maxChild = maximize(s, 3).getChild();
        return maxChild;
    }

}
