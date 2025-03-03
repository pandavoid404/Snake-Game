package com.pandavoid.snakegame.ui.window;

import java.awt.event.ActionListener;

class GamePanel {
	private final ImagePanel panel;
	public GamePanel() {
		panel = new ImagePanel("assets/defultbackgroundsnakegameboard.png", 1200 , 700, 0,1);
		panel.CreateLabel("score player 1: ",0,0,20);

		panel.CreateLabel("score player 2: ",1,0,20);
		}
	public ImagePanel getPanel() {
		return panel;
	}
}

