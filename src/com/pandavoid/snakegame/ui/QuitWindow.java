package com.pandavoid.snakegame.ui;

import java.awt.*;
import java.awt.event.ActionListener;

public class QuitWindow {
	private static final short height = 700;
	private static final short width = 1000;
	public QuitWindow(ActionListener QuitGameListener) {
		Window window = new Window("SnakeGame", true, width, height);
		window.CreateButton( 0 , 40 , "Quit Game", Color.BLACK, Color.WHITE , QuitGameListener);
		window.CreateButton( 0 , 40 , "Cancel", Color.BLACK, Color.WHITE , );
		//TODO: add buttons here
		window.ShowDisplay();
	}
}
