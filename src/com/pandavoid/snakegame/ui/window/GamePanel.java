package com.pandavoid.snakegame.ui.window;

class GamePanel {
	private final ImagePanel panel;
	public GamePanel() {
		panel = new ImagePanel("assets/defultbackgroundsnakegameboard.png", 600 , 400 );
		panel.CreateLabel("Snake Game");
		}
	public ImagePanel getPanel() {
		return panel;
	}
}
