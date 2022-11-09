package gui;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Chip {

	public static final Image RED_CHIP = new ImageIcon("Assets/Red.png").getImage();
	public static final Image YELLOW_CHIP = new ImageIcon("Assets/Yellow.png").getImage();

	private Image color;
	private int x;
	private int y;

	public Chip(Image color, int x, int y) {
		this.color = color;
		this.x = x;
		this.y = y;
	}

	public Image getColor() {
		return color;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
