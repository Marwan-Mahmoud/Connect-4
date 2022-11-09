package gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

	private Image background;
	private List<Chip> chips;

	public MyPanel() {
		background = new ImageIcon("Assets/Board.png").getImage();
		chips = new ArrayList<>();
		this.setPreferredSize(new Dimension(background.getWidth(null), background.getHeight(null)));
		this.addMouseListener(new ClickListener(this));
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(background, 0, 0, null);
		for (Chip chip : chips)
			g2d.drawImage(chip.getColor(), 76 + 92 * chip.getX(), 35 + 92 * chip.getY(), 75, 75, null);
		// g2d.drawImage(redChip, 76, 35, 75, 75, null);
		// g2d.drawImage(yellowChip, 13 + 90 * 2, 5 + 80 * 3, 75, 75, null);
	}

	public void addChip(Chip chip) {
		chips.add(chip);
		this.repaint();
	}
}
