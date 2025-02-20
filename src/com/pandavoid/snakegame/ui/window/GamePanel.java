package com.pandavoid.snakegame.ui.window;

import javax.swing.*;

class GamePanel {
	private Panel panel;
	public GamePanel() {
		panel = new Panel(600, 800);
		panel.CreateLabel("Snake Game");

		}
	public Panel getPanel() {
		return panel;
	}
}
