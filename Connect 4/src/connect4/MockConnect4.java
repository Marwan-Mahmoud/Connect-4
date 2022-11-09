package connect4;

import java.awt.Image;

import gui.Chip;

public class MockConnect4 implements IConnect4 {

	private int[] y;
	private Image color;

	public MockConnect4() {
		y = new int[7];
		for (int i = 0; i < y.length; i++) {
			y[i] = 5;
		}
		color = Chip.YELLOW_CHIP;
	}

	@Override
	public Chip put(int column) {
		if (column < 0)
			return null;

		int row = y[column]--;
		if (row < 0)
			return null;

		color = color == Chip.RED_CHIP ? Chip.YELLOW_CHIP : Chip.RED_CHIP;
		return new Chip(color, column, row);
	}
}
