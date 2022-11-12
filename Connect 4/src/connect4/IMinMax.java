package connect4;

public abstract class IMinMax {
	protected int depth = 4;

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getDepth() {
		return depth;
	}

	public abstract Connect4 aiDecision(Connect4 s);
}
