package com.pandavoid.snakegame.ui.window;

import java.awt.*;
import java.awt.event.ActionListener;

public class MainWindow {
	private final Window window;
	private static final short height = 700;
	private static final short width = 1000;
	public MainWindow(ActionListener StartGameAction, ActionListener SettingsAction, ActionListener CreditsAction, ActionListener quitAction) {
		window = new Window("SnakeGame",width,height);
		window.SetMainWindow(true);
		DisplayMenu(StartGameAction, SettingsAction, CreditsAction, quitAction);
		window.ShowDisplay();
	}

	private void DisplayMenu(ActionListener StartGameAction, ActionListener SettingsAction, ActionListener CreditsAction, ActionListener quitAction) {
		window.CreateLabel( 0, 0, "SnakeGame");
		window.CreateButton(0 , 10 , "StartGame", Color.BLACK, Color.WHITE, StartGameAction);
		window.CreateButton(0,20,"Settings" ,Color.BLACK, Color.WHITE, SettingsAction);
		window.CreateButton( 0 , 30 , "Credits",Color.BLACK, Color.WHITE , CreditsAction);
		window.CreateButton( 0 , 40 , "Quit Game",Color.BLACK, Color.WHITE , quitAction);
	}
}
