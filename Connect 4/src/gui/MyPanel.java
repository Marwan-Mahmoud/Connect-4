package gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

	private static final int rows = 6;
	private static final int columns = 7;

	private Controller controller;
	private Image background;
	private Image[][] chips;

	public MyPanel(Controller controller) {
		this.controller = controller;
		background = new ImageIcon("Assets/Board.png").getImage();
		chips = new Image[rows][columns];
		this.setPreferredSize(new Dimension(background.getWidth(null), background.getHeight(null)));
		this.addMouseListener(new ClickListener(this));
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++)
				g.drawImage(chips[i][j], 76 + 92 * j, 35 + 92 * i, 75, 75, null);
		}
		g.setFont(new Font("Tahoma", Font.BOLD, 16));
		g.drawString("User score = " + controller.getUserScore(), 175, 615);
		g.drawString("Agent score = " + controller.getAgentScore(), 500, 615);
	}

	public void putChip(int column) {
		controller.putChip(column);
	}

	public void setChips(Image[][] chips) {
		this.chips = chips;
		this.repaint();
		this.getFocusCycleRootAncestor().repaint();
	}
}
