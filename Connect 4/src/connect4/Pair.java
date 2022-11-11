package connect4;

public class Pair {

    int utility;
    Connect4 child;

    public Pair(Connect4 c, int u) {
        this.child = c;
        this.utility = u;
    }

    public Connect4 getChild() {
        return child;
    }

    public void setChild(Connect4 child) {
        this.child = child;
    }

    public int getUtility() {
        return utility;
    }

    public void setUtility(int utility) {
        this.utility = utility;
    }
}
