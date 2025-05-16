package com.pandavoid.snakegame.ui;

import com.pandavoid.snakegame.Main;
import com.pandavoid.snakegame.config.GameConfig;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {
	private final Window window;
	private static final short height = 700;
	private static final short width = 1000;
	private static JLabel labelplayer1;
	private static JLabel labelplayer2;
	private GamePanel gamePanel;
	private ActionMap actionMap;
	public MainWindow(ActionListener StartGameAction, ActionListener SettingsAction, ActionListener CreditsAction, ActionListener quitAction) {
		window = new Window("SnakeGame",width,height);
		window.setMainWindow();
		window.setFullscreen();
		displayMenu(StartGameAction, SettingsAction, CreditsAction, quitAction);
		window.showDisplay();
		JComponent contentPane = (JComponent) window.getContentPane();
		InputMap inputMap = contentPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		this.actionMap = contentPane.getActionMap();

		// Bind a key (e.g., "ENTER")
		inputMap.put(KeyStroke.getKeyStroke("ESCAPE"), "Escape Menu");
		actionMap.put("Escape Menu", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("escape menu requested");
				Main.escMenuRequest();
			}
		});
		inputMap.put(KeyStroke.getKeyStroke("W"), "Move UP snake 1");
		inputMap.put(KeyStroke.getKeyStroke("D"), "Move RIGHT snake 1");
		inputMap.put(KeyStroke.getKeyStroke("S"), "Move DOWN snake 1");
		inputMap.put(KeyStroke.getKeyStroke("A"), "Move LEFT snake 1");
		inputMap.put(KeyStroke.getKeyStroke("LEFT"), "Move LEFT snake 2");
		inputMap.put(KeyStroke.getKeyStroke("UP"), "Move UP snake 2");
		inputMap.put(KeyStroke.getKeyStroke("DOWN"), "Move DOWN snake 2");
		inputMap.put(KeyStroke.getKeyStroke("RIGHT"), "Move RIGHT snake 2");

	}

	public void displayMenu(ActionListener StartGameAction, ActionListener SettingsAction, ActionListener CreditsAction, ActionListener quitAction) {
		window.clearDisplay();
		window.createLabel("Snake Game" ,80, 0, 0, 1);
		window.createButton(0 , 1 ,1, "StartGame", StartGameAction);
		window.createButton(0,2,1,"Settings" , SettingsAction);
		window.createButton( 0 , 3 ,1, "Credits", CreditsAction);
		window.createButton( 0 , 4 , 1,"Quit Game", quitAction);
		window.updateDisplay();
	}
	public Dimension getSize(){
		return window.getWindowSize();
	}
	public void displayPreGameSettings(ActionListener SinglePlayer , ActionListener Versus, ActionListener backListener ) {
		window.clearDisplay();
		window.createButton(0 , 1 ,1, "1 Player", SinglePlayer);
		window.createButton(0 , 2,2, "Back", backListener );
		window.createButton(1  , 1,1, "2 Players", Versus );
		window.updateDisplay();
	}
	public void displayPlayerSelection(GameConfig gameConfig, ActionListener StartGameAction, ActionListener backListener){
		window.clearDisplay();
		Panel panel1 = window.createPanel(0,1);
		panel1.createLabel("Select Player 1" , 15 , 2 ,0, 0 );
		ActionListener ChangeColorPlayer1Listener = e -> changeColor(labelplayer1, 0, gameConfig, 1);
		ActionListener BackColorPlayer1Listener = e -> changeColor(labelplayer1, 0, gameConfig , -1);
		labelplayer1 = panel1.createLabel("    " , 35 , 2 ,1, 0 );
		labelplayer1.setOpaque(true);
		panel1.createButton(ChangeColorPlayer1Listener, 0, 2, 100, 50);
		panel1.createButton(BackColorPlayer1Listener, 1, 2, 100, 50);
		if (gameConfig.getPlayers()==2) {
			Panel panel2 = window.createPanel(1,1);
			ActionListener ChangeColorPlayer2Listener = e -> changeColor(labelplayer2, 1, gameConfig,1);
			ActionListener BackColorPlayer2Listener = e -> changeColor(labelplayer2, 1, gameConfig,-1);
			panel2.createLabel("Select Player2" ,15 ,2 ,0, 0 );
			labelplayer2 = panel2.createLabel("    ",35,2,1, 0 );
			labelplayer2.setOpaque(true);
			panel2.createButton(ChangeColorPlayer2Listener, 0, 2, 100, 50);
			panel2.createButton(BackColorPlayer2Listener, 1, 2, 100, 50);
		}
		window.createButton(0 , 3,2, "Start Game", StartGameAction);
		window.createButton(0 , 4,2, "Back", backListener );
		window.updateDisplay();
	}
	public void changeColor(JLabel Color_label, int player, GameConfig gameConfig, int modify) {
		gameConfig.getPlayerConfig(player).changeColor(modify);
		Color_label.setBackground(gameConfig.getPlayerConfig(player).getColor());
		window.updateDisplay();
	}
	public void displayCredits(ActionListener backListener){
		window.clearDisplay();
		window.createLabel("Programmers", 18, 0, 0, 1);
		window.createLabel("EndlessVoid_303", 13, 0, 1, 1);
		window.createLabel("MrPanda_071", 13, 0, 2, 1);
		window.createLabel("GraphicalDesigner", 18, 0, 3, 1);
		window.createLabel("MrPanda_071", 13, 0, 4, 1);
		window.createLabel("GameTesters", 18, 0, 5, 1);
		window.createLabel("Animator", 18, 0, 6, 1);
		window.createLabel("Special thanks", 18, 0, 7, 1);
		window.createLabel("EndlessVoid_303 Mom", 13, 0, 8, 1);
		window.createButton(0 , 9,1, "Back", backListener );
		window.updateDisplay();
	}
	public void displaySettings(ActionListener backListener) {
		window.clearDisplay();
		window.createLabel("Settings", 30, 0, 0, 2);
		window.createLabel("Sound", 15, 0, 1, 1);
		window.createButton(1 , 1 ,1, "On", null);
		window.createLabel("Music", 15, 0, 2, 1);
		window.createButton(1 , 2,1, "On", null);
		window.createButton(0 , 3,2, "Back", backListener );
		window.updateDisplay();
	}
	public GamePanel displayGame() {
		window.clearDisplay();
		gamePanel = new GamePanel();
		window.addPanel(gamePanel.getPanel());
		window.updateDisplay();
		return gamePanel;
	}
	public java.awt.Window getWindow() {
		return window.getWindow();
	}
	public void displayBugScreen(ActionListener backListener){
		window.clearDisplay();
		window.createLabel("Report Bug", 40,0 ,4, 2);
		window.createJTextArea("In the title box please provide a clear and short bug titlen\n" +
				"(Example: \"Game crashes when opening inventory\")",
				10,0 ,5,false , 0 , 0,600,200);
		window.createJTextArea("Title for the bug",
				10,0 ,6,true, 10 ,2,600,200);
		window.createJTextArea("Give a detailed description of the bug.\n" +
				"-When did it happen? \n" +
				"-What were you doing? \n" +
				"-What should have happened instead? \n" +
				"-Provide steps so we can recreate the bug.",
				10,0 ,7,false, 10 ,0 , 600,200 );
		window.createJTextArea("Description",
				10,0 ,8,true, 10 ,0,600,200  );
		window.createButton(0 , 9,1, "Back", backListener );
		window.updateDisplay();
	}
	public ActionMap getActionmap(){
		return actionMap;
	}
	public GamePanel getGamePanel() {
		return gamePanel;
	}
	public void removeGamePanel() {
		gamePanel = null;
	}
}
