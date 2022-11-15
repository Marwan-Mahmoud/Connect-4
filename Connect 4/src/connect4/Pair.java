package connect4;

public class Pair {

	private Connect4 child;
	private int utility;

	public Pair(Connect4 child, int utility) {
		this.child = child;
		this.utility = utility;
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
