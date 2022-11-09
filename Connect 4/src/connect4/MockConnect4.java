package connect4;

import java.awt.Image;

import gui.Chip;

public class MockConnect4 implements IConnect4 {

	private int[] ys;
	private Image color = Chip.YELLOW_CHIP;

	public MockConnect4() {
		ys = new int[7];
		for (int i = 0; i < ys.length; i++) {
			ys[i] = 5;
		}
	}

	@Override
	public Chip put(int column) {
		int x = column;
		int y = ys[x]--;
		color = color == Chip.RED_CHIP ? Chip.YELLOW_CHIP : Chip.RED_CHIP;
		return new Chip(color, x, y);
	}
}
