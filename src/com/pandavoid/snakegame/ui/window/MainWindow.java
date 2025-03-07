package com.pandavoid.snakegame.ui.window;

import com.pandavoid.snakegame.game.Game;
import com.pandavoid.snakegame.game.config.GameConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainWindow {
	private final Window window;
	private static final short height = 700;
	private static final short width = 1000;
	private static JLabel labelplayer1;
	private static JLabel labelplayer2;
	private GamePanel gamePanel;
	public MainWindow(ActionListener StartGameAction, ActionListener SettingsAction, ActionListener CreditsAction, ActionListener quitAction) {
		window = new Window("SnakeGame",width,height);
		window.SetMainWindow();
		window.SetFullscreen();
		DisplayMenu(StartGameAction, SettingsAction, CreditsAction, quitAction);
		window.ShowDisplay();
	}

	public void DisplayMenu(ActionListener StartGameAction, ActionListener SettingsAction, ActionListener CreditsAction, ActionListener quitAction) {
		window.ClearDisplay();
		window.CreateLabel("Snake Game" ,80, 0, 0);
		window.CreateButton(0 , 1 ,1, "StartGame", StartGameAction);
		window.CreateButton(0,2,1,"Settings" , SettingsAction);
		window.CreateButton( 0 , 3 ,1, "Credits", CreditsAction);
		window.CreateButton( 0 , 4 , 1,"Quit Game", quitAction);
		window.UpdateDisplay();
	}
	public Dimension getSize(){
		return window.GetWindowSize();
	}
	public void DisplayPreGameSettings(ActionListener SinglePlayer , ActionListener Versus,ActionListener backListener ) {
		window.ClearDisplay();
		window.CreateButton(0 , 1 ,1, "1 Player", SinglePlayer);
		window.CreateButton(0 , 2,2, "Back", backListener );
		window.CreateButton(1  , 1,1, "2 Players", Versus );
		window.UpdateDisplay();
	}
	public void DisplayPlayerSelection(GameConfig gameConfig, ActionListener StartGameAction, ActionListener backListener){
		window.ClearDisplay();
		Panel panel1 = window.CreatePanel(0,1);
		panel1.CreateLabel("Select Player 1" , 15 , 2 ,0, 0 );
		ActionListener ChangeColorPlayer1Listener = e -> ChangeColor(labelplayer1, 0, gameConfig, 1);
		ActionListener BackColorPlayer1Listener = e -> ChangeColor(labelplayer1, 0, gameConfig , -1);
		labelplayer1 = panel1.CreateLabel("    " , 35 , 2 ,1, 0 );
		labelplayer1.setOpaque(true);
		panel1.CreateButton(ChangeColorPlayer1Listener, 0, 2, 100, 50);
		panel1.CreateButton(BackColorPlayer1Listener, 1, 2, 100, 50);
		if (gameConfig.getPlayers()==2) {
			Panel panel2 = window.CreatePanel(1,1);
			ActionListener ChangeColorPlayer2Listener = e -> ChangeColor(labelplayer2, 1, gameConfig,1);
			ActionListener BackColorPlayer2Listener = e -> ChangeColor(labelplayer2, 1, gameConfig,-1);
			panel2.CreateLabel("Select Player2" ,15 ,2 ,0, 0 );
			labelplayer2 = panel2.CreateLabel("    ",35,2,1, 0 );
			labelplayer2.setOpaque(true);
			panel2.CreateButton(ChangeColorPlayer2Listener, 0, 2, 100, 50);
			panel2.CreateButton(BackColorPlayer2Listener, 1, 2, 100, 50);
		}
		window.CreateButton(0 , 3,2, "Start Game", StartGameAction);
		window.CreateButton(0 , 4,2, "Back", backListener );
		window.UpdateDisplay();
	}
	public void ChangeColor(JLabel Color_label, int player, GameConfig gameConfig,int modify) {
		gameConfig.getPlayerConfig(player).ChangeColor(modify);
		Color_label.setBackground(gameConfig.getPlayerConfig(player).getColor());
		window.UpdateDisplay();
	}
	public void DisplayCredits( ActionListener backListener){
		window.ClearDisplay();
		window.CreateLabel("Programmers", 18, 0, 0);
		window.CreateLabel("EndlessVoid_303", 13, 0, 1);
		window.CreateLabel("MrPanda_071", 13, 0, 2);
		window.CreateLabel("GraphicalDesigner", 18, 0, 3);
		window.CreateLabel("MrPanda_071", 13, 0, 4);
		window.CreateLabel("GameTesters", 18, 0, 5);
		window.CreateLabel("Animator", 18, 0, 6);
		window.CreateLabel("Special thanks", 18, 0, 7);
		window.CreateLabel("EndlessVoid_303 Mom", 13, 0, 8);
		window.CreateButton(0 , 9,1, "Back", backListener );
		window.UpdateDisplay();
	}
	public void DisplayGame(Game game) {
		window.ClearDisplay();
		gamePanel = new GamePanel(game);
		window.AddPanel(gamePanel.getPanel());
		window.UpdateDisplay();
	}
}
