package com.fmpoerio.quackmario.tilemap;

import com.fmpoerio.quackmario.game.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Background {

	private Image image;

	private double x;
	private double y;
	private double dx;
	private double dy;

	private double moveScale;

	public Background(String s, double ms) {

		try {
			image =  new ImageIcon(s).getImage().getScaledInstance(GamePanel.getWIDTH(),GamePanel.getHEIGHT(),Image.SCALE_SMOOTH);
			//image = ImageIO.read(new File(s)).;
			moveScale = ms;
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void setPosition(double x, double y) {
		this.x = (x * moveScale) % GamePanel.getWIDTH();
		this.y = (y * moveScale) % GamePanel.getHEIGHT();
	}

	public void setVector(double dx, double dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public void update() {
		x += dx;
		y += dy;
	}

	public void draw(Graphics g) {
		//Graphics2D g2 = (Graphics2D) g ;
		g.drawImage(image, (int) x, (int) y, null);

		if (x < 0) {
			g.drawImage(image, (int) x + GamePanel.getWIDTH(), (int) y, null);
		}
		if (x > 0) {
			g.drawImage(image, (int) x - GamePanel.getHEIGHT(), (int) y, null);
		}
	}

}
