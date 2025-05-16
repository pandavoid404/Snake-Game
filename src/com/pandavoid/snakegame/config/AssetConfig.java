package com.pandavoid.snakegame.config;

import java.awt.*;

public class AssetConfig {
	private Point position;
	private Color color;

	public AssetConfig() {

	}

	public Point getPosition() {
		return position;
	}

	public Color getColor() {
		return color;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}
