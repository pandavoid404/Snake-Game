package com.pandavoid.snakegame.game.config;

import java.awt.*;

public class PlayerConfig {
	private Color color;
	public PlayerConfig() {
		color = Color.BLUE;
	}
	public void SetColor(Color newColor) {
		color = newColor;
	}

	public Color getColor() {
		return color;
	}
}
