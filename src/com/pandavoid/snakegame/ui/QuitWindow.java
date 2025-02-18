package com.pandavoid.snakegame.ui;

import java.awt.*;
import java.awt.event.ActionListener;

public class QuitWindow {
	private final Window window;
	private static final short height = 100;
	private static final short width = 200;
	public QuitWindow(ActionListener QuitGameListener) {
		window = new Window("SnakeGame", width, height);
		window.HideControls(true);
		ActionListener CancelListener = e-> Cancel();
		window.CreateButton( 0 , 40 , "Quit Game", Color.BLACK, Color.WHITE , QuitGameListener);
		window.CreateButton( 0 , 80 , "Cancel", Color.BLACK, Color.WHITE , CancelListener);
		//TODO: add buttons here
		window.ShowDisplay();
	}
	private void Cancel() {
		window.Close();
	}
}
