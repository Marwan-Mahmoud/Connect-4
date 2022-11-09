package gui;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickListener implements MouseListener {

	private MyPanel panel;

	public ClickListener(MyPanel panel) {
		this.panel = panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Graphics2D g2d = (Graphics2D) panel.getGraphics();
		// g2d.drawImage(panel.yellowChip, 13 + 90 * 2, 5 + 80 * 3, 75, 75, null););
		// g2d.drawImage(panel.redChip, 76, 35, 75, 75, null);
		int x = getColumn(e.getX());
		panel.addChip(new Chip(Chip.RED_CHIP, x, 0));
		// panel.paint(g2d);
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
