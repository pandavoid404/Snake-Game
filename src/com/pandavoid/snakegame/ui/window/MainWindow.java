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

	public void DisplayMenu(ActionListener StartGameAction, ActionListener SettingsAction, ActionListener CreditsAction, ActionListener quitAction) {
		window.ClearDisplay();
		window.CreateLabel( 0, 0, "SnakeGame");
		window.CreateButton(0 , 1 ,1, "StartGame", Color.BLACK, Color.WHITE, StartGameAction);
		window.CreateButton(0,2,1,"Settings" ,Color.BLACK, Color.WHITE, SettingsAction);
		window.CreateButton( 0 , 3 ,1, "Credits",Color.BLACK, Color.WHITE , CreditsAction);
		window.CreateButton( 0 , 4 , 1,"Quit Game",Color.BLACK, Color.WHITE , quitAction);
		window.UpdateDisplay();
	}

	public void DisplayPreGameSettings(ActionListener one_playergame , ActionListener two_playergame,ActionListener backListener ) {
		window.ClearDisplay();
		window.CreateButton(0 , 1 ,1, "1 Player", Color.BLACK, Color.WHITE, one_playergame);
		window.CreateButton(0 , 2,2, "Back", Color.BLACK, Color.WHITE, backListener );
		window.CreateButton(1  , 1,1, "2 Players", Color.BLACK, Color.WHITE, two_playergame );
		window.UpdateDisplay();
	}
	public void DisplayPlayerSelection(int players){
		window.ClearDisplay();
		Panel panel1 = window.CreatePanel(0,0,500,700);
		panel1.CreateLabel(0,0,"Select Player");
		if (players==2) {
			Panel panel2 = window.CreatePanel(0,1,500,700);
			panel2.CreateLabel(0,0,"Select Player2");
		}
		window.UpdateDisplay();
	}

}
