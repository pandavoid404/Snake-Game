package com.pandavoid.snakegame.ui.window;

class GamePanel {
	private final ImagePanel panel;
	public GamePanel() {
		panel = new ImagePanel("assets/defultbackgroundsnakegameboard.png", 1200 , 700 );
		panel.CreateLabel("Snake Game",0,0,20);
		}
	public ImagePanel getPanel() {
		return panel;
	}
}
