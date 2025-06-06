package com.pandavoid.snakegame.ui;

import com.pandavoid.snakegame.Logger;
import com.pandavoid.snakegame.Main;
import com.pandavoid.snakegame.config.GameConfig;
import com.pandavoid.snakegame.enums.Difficulty;
import com.pandavoid.snakegame.enums.Language;
import com.pandavoid.snakegame.enums.LogType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MainWindow {
	private static final short HEIGHT = 700;
	private static final short WIDTH = 1000;

	private static JLabel labelplayer1;
	private static JLabel labelplayer2;

	private final Window window;

	private GamePanel gamePanel;
	private ActionMap actionMap;

	public MainWindow(ActionListener StartGameAction, ActionListener SettingsAction, ActionListener CreditsAction, ActionListener quitAction) {
		window = new Window("SnakeGame", WIDTH, HEIGHT);
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
				Logger.info(LogType.DISPLAY,"escape menu requested");
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

	public Dimension getSize(){
		return window.getWindowSize();
	}

	public java.awt.Window getJavaWindow() {
		return window.getWindow();
	}
	public Window getwindow(){
		return window;
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

	public void displayMenu(ActionListener StartGameAction, ActionListener SettingsAction, ActionListener CreditsAction, ActionListener quitAction) {
		window.clearDisplay();
		window.createLabel(Main.getLocaleText("mainMenu.gameName") ,80, 0, 0, 1);
		window.createButton(0 , 1 ,1, Main.getLocaleText("mainMenu.start"), StartGameAction);
		window.createButton(0,2,1,Main.getLocaleText("mainMenu.settings") , SettingsAction);
		window.createButton( 0 , 3 ,1, Main.getLocaleText("mainMenu.credits"), CreditsAction);
		window.createButton( 0 , 4 , 1,Main.getLocaleText("mainMenu.quit"), quitAction);
		window.updateDisplay();
	}

	public void displayPreGameSettings(ActionListener SinglePlayer , ActionListener Versus, ActionListener backListener ) {
		window.clearDisplay();
		window.createButton(0 , 1 ,1, Main.getLocaleText("playerSelector.1player"), SinglePlayer);
		window.createButton(0 , 2,2, Main.getLocaleText("playerSelector.back"), backListener );
		window.createButton(1  , 1,1, Main.getLocaleText("playerSelector.2players"), Versus );
		window.updateDisplay();
	}

	public void displayPlayerSelection(GameConfig gameConfig, ActionListener StartGameAction, ActionListener backListener ){
		window.clearDisplay();
		Panel panel1 = window.createPanel(0,0,2);
		panel1.createLabel(Main.getLocaleText("playerPreGameSelector.playerLabel.player1") , 15 , 2 ,0, 0 );
		ActionListener ChangeColorPlayer1Listener = e -> changeColor(labelplayer1, 0, gameConfig, 1);
		ActionListener BackColorPlayer1Listener = e -> changeColor(labelplayer1, 0, gameConfig , -1);
		labelplayer1 = panel1.createLabel("    " , 35 , 2 ,1, 0);
		labelplayer1.setOpaque(true);
		panel1.createButton(ChangeColorPlayer1Listener, 0, 2, 100, 50,Main.getLocaleText("playerPreGameSelector.color.back"));
		panel1.createButton(BackColorPlayer1Listener, 1, 2, 100, 50,Main.getLocaleText("playerPreGameSelector.color.next"));
		if (gameConfig.getPlayers()==2) {
			Panel panel2 = window.createPanel(2,0,2);
			ActionListener ChangeColorPlayer2Listener = e -> changeColor(labelplayer2, 1, gameConfig,1);
			ActionListener BackColorPlayer2Listener = e -> changeColor(labelplayer2, 1, gameConfig,-1);
			panel2.createLabel(Main.getLocaleText("playerPreGameSelector.playerLabel.player2") ,15,2 ,0, 1);
			labelplayer2 = panel2.createLabel("    ",35,2,1, 1);
			labelplayer2.setOpaque(true);
			panel2.createButton(ChangeColorPlayer2Listener, 1, 3, 100, 50,Main.getLocaleText("playerPreGameSelector.color.back"));
			panel2.createButton(BackColorPlayer2Listener, 2, 3, 100, 50,Main.getLocaleText("playerPreGameSelector.color.next"));
		}
		ArrayList<String> difficulty = new ArrayList<>();
		for (Difficulty d : Difficulty.values()) {
			difficulty.add(d.toString());
		}
		window.createDropdown(difficulty ,1,3,3,200,20);
		window.createButton(0 , 4,4, Main.getLocaleText("playerPreGameSelector.start"), StartGameAction);
		window.createButton(0, 5,4, Main.getLocaleText("playerPreGameSelector.back"), backListener );
		window.updateDisplay();
	}

	public void changeColor(JLabel Color_label, int player, GameConfig gameConfig, int modify) {
		gameConfig.getPlayerConfig(player).changeColor(modify);
		Color_label.setBackground(gameConfig.getPlayerConfig(player).getColor());
		window.updateDisplay();
	}

	public void displayCredits(ActionListener backListener){
		window.clearDisplay();
		window.createLabel(Main.getLocaleText("credits.programmers"), 18, 0, 0, 1);
		window.createLabel("EndlessVoid_303", 13, 0, 1, 1);
		window.createLabel("MrPanda_071", 13, 0, 2, 1);
		window.createLabel(Main.getLocaleText("credits.graphicalDesigner"), 18, 0, 3, 1);
		window.createLabel("MrPanda_071", 13, 0, 4, 1);
		window.createLabel(Main.getLocaleText("credits.gametester"), 18, 0, 5, 1);
		window.createLabel(Main.getLocaleText("credits.specialThanks"), 18, 0, 7, 1);
		window.createButton(0 , 9,1, Main.getLocaleText("credits.back"), backListener );
		window.updateDisplay();
	}

	public void displaySettings(ActionListener backListener) {
		ArrayList<String> language = new ArrayList<>();
		for (Language d : Language.values()) {
			language.add(d.getLanguageName()+" ("+d.getLocale()+")");
		}
		window.clearDisplay();
		window.createLabel(Main.getLocaleText("settings.settingsLabel"), 30, 0, 0, 2);
		window.createLabel("language", 15, 0, 2, 1);
		window.createDropdown(language,1,2,1,200,20);
		window.createButton(0 , 3,2, Main.getLocaleText("settings.back"), backListener );
		window.updateDisplay();
	}

	public GamePanel displayGame() {
		window.clearDisplay();
		gamePanel = new GamePanel();
		window.addPanel(gamePanel.getPanel());
		window.updateDisplay();
		return gamePanel;
	}

	public void displayBugScreen(ActionListener backListener){
		window.clearDisplay();
		window.createLabel(Main.getLocaleText("bugReport.bugReportLabel"), 40,0 ,4, 2);
		window.createJTextArea(Main.getLocaleText("bugReport.titleExplanation"),
				10,0 ,5,false , 0 , 0,600,200);
		window.createJTextArea(Main.getLocaleText("bugReport.titleInput"),
				10,0 ,6,true, 10 ,2,600,200);
		window.createJTextArea(Main.getLocaleText("bugReport.descriptionExplanation"),
				10,0 ,7,false, 10 ,0 , 600,200 );
		window.createJTextArea(Main.getLocaleText("bugReport.descriptionInput"),
				10,0 ,8,true, 10 ,0,600,200  );
		window.createButton(0 , 9,1, "Back", backListener );
		window.updateDisplay();
	}
}
