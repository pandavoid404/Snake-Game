package com.pandavoid.snakegame.ui.window;

import com.pandavoid.snakegame.game.config.GameConfig;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainWindow {
	private final Window window;
	private static final short height = 700;
	private static final short width = 1000;
	public MainWindow(ActionListener StartGameAction, ActionListener SettingsAction, ActionListener CreditsAction, ActionListener quitAction) {
		window = new Window("SnakeGame",width,height);
		window.SetMainWindow();
		DisplayMenu(StartGameAction, SettingsAction, CreditsAction, quitAction);
		window.ShowDisplay();
	}

	public void DisplayMenu(ActionListener StartGameAction, ActionListener SettingsAction, ActionListener CreditsAction, ActionListener quitAction) {
		window.ClearDisplay();
		window.CreateLabel();
		window.CreateButton(0 , 1 ,1, "StartGame", StartGameAction);
		window.CreateButton(0,2,1,"Settings" , SettingsAction);
		window.CreateButton( 0 , 3 ,1, "Credits", CreditsAction);
		window.CreateButton( 0 , 4 , 1,"Quit Game", quitAction);
		window.UpdateDisplay();
	}

	public void DisplayPreGameSettings(ActionListener one_playergame , ActionListener two_playergame,ActionListener backListener ) {
		window.ClearDisplay();
		window.CreateButton(0 , 1 ,1, "1 Player", one_playergame);
		window.CreateButton(0 , 2,2, "Back", backListener );
		window.CreateButton(1  , 1,1, "2 Players", two_playergame );
		window.UpdateDisplay();
	}
	public void DisplayPlayerSelection(GameConfig gameConfig, ActionListener StartGameAction, ActionListener backListener){
		window.ClearDisplay();
		Panel panel1 = window.CreatePanel(0);
		panel1.CreateLabel("Select Player 1");
		ActionListener ChangeColorPlayer1Listener = e -> ChangeColor((JButton) e.getSource(), 0, gameConfig);
		panel1.CreateButton(ChangeColorPlayer1Listener);
		window.CreateButton(0 , 2,2, "Back", backListener );
		if (gameConfig.getPlayers()==2) {
			Panel panel2 = window.CreatePanel(1);
			ActionListener ChangeColorPlayer2Listener = e -> ChangeColor((JButton) e.getSource(), 0, gameConfig);
			panel2.CreateLabel("Select Player2");
			panel2.CreateButton(ChangeColorPlayer2Listener);
		}
		window.UpdateDisplay();
	}
	public void ChangeColor(JButton source, int player, GameConfig gameConfig) {
		gameConfig.getPlayerConfig(player).nextColor();
		source.setBackground(gameConfig.getPlayerConfig(player).getColor());
		window.UpdateDisplay();
	}

}
