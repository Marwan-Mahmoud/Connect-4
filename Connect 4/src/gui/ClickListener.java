package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import connect4.IConnect4;

public class ClickListener implements MouseListener {

	private MyPanel panel;
	private IConnect4 connect4;

	public ClickListener(MyPanel panel, IConnect4 connect4) {
		this.panel = panel;
		this.connect4 = connect4;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int coloumn = getColumn(e.getX());
		Chip chip = connect4.put(coloumn);
		panel.addChip(chip);
	}

	private int getColumn(int x) {
		int column = -1;
		int start = 71;
		int end = start + 83;
		for (int i = 0; i < 7; i++) {
			if (start < x && x < end) {
				column = i;
				break;
			}
			start = end + 9;
			end = start + 83;
		}
		return column;
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
