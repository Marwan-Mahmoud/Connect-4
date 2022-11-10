package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.LinkedList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import connect4.IConnect4;

public class MyPanel extends JPanel {

	private IConnect4 connect4;
	private Image background;
	private List<Chip> chips;

	public MyPanel(IConnect4 connect4) {
		this.connect4 = connect4;
		background = new ImageIcon("Assets/Board.png").getImage();
		chips = new LinkedList<>();
		this.setPreferredSize(new Dimension(background.getWidth(null), background.getHeight(null)));
		this.addMouseListener(new ClickListener(this));
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
		for (Chip chip : chips)
			g.drawImage(chip.getColor(), 76 + 92 * chip.getX(), 35 + 92 * chip.getY(), 75, 75, null);
	}

	public void putChip(int column) {
		Chip chip = connect4.put(column);
		if (chip != null) {
			chips.add(chip);
			this.repaint();
		}
	}
}
