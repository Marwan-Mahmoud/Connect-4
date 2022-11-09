package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickListener implements MouseListener {

	private MyPanel panel;

	public ClickListener(MyPanel panel) {
		this.panel = panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int column = getColumn(e.getX());
		if (column >= 0)
			panel.putChip(column);
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
