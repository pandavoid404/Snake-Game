package com.pandavoid.snakegame;

import com.pandavoid.snakegame.enums.MainWindowState;
import com.pandavoid.snakegame.game.Game;
import com.pandavoid.snakegame.game.config.GameConfig;
import com.pandavoid.snakegame.ui.window.EscWindow;
import com.pandavoid.snakegame.ui.window.MainWindow;
import com.pandavoid.snakegame.ui.window.QuitWindow;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Main {
    private static Game game;
    private static MainWindow mainWindow;
    private static GameConfig gameConfig;
    private static EscWindow escWindow;
    private static MainWindowState mainWindowState;

    
	public static void main(String[]args) {
        mainWindowState = MainWindowState.MAIN_MENU;
        ActionListener QuitListener = Main::QuitGameRequest;
        ActionListener CreditsListener = e -> Credits();
        ActionListener SettingsListener = e -> Settings();
        ActionListener StartGameListener = e -> PreGameSettings();
        mainWindow = new MainWindow(StartGameListener, SettingsListener, CreditsListener, QuitListener);
	}

    private static void ShowMainMenu() {
        mainWindowState = MainWindowState.MAIN_MENU;
        ActionListener QuitListener = Main::QuitGameRequest;
        ActionListener CreditsListener = e -> Credits();
        ActionListener SettingsListener = e -> Settings();
        ActionListener StartGameListener = e -> PreGameSettings();
        mainWindow.DisplayMenu(StartGameListener, SettingsListener, CreditsListener, QuitListener);
    }

    public static void EscMenuToMainMenu() {
        CloseEscMenu();
        ShowMainMenu();
    }

    public static void EscMenuRequest() {
        if (escWindow != null) {
            CloseEscMenu();
        } else if (mainWindowState == MainWindowState.PLAYING ) {
            Window window = mainWindow.GetWindow();
            escWindow = new EscWindow(window.getLocation(),window.getWidth(),window.getHeight());
        }
    }

    public static void CloseEscMenu() {
        escWindow.Close();
        escWindow = null;
    }

    private static void QuitGameRequest(ActionEvent event) {
        JButton source = (JButton) event.getSource();
        JPanel panel = (JPanel) source.getParent();
        JLayeredPane pane = (JLayeredPane) panel.getParent();
        JRootPane rootPane = (JRootPane) pane.getParent();
        Window mainwindow = (Window) rootPane.getParent();
        System.out.println("requesting to quit game");
        ActionListener QuitGameListener = e -> QuitGame();
        new QuitWindow(QuitGameListener,mainwindow.getLocation(),mainwindow.getWidth(),mainwindow.getHeight());
    }
    private static void QuitGame(){
        System.out.println("quiting game");
        System.exit(0);
    }
    public static void Credits(){
        ActionListener backListener = e -> ShowMainMenu();
        mainWindow.DisplayCredits(backListener); // Directly call the DisplayCredits() method
        System.out.println("Credits");

    }
    public static void Settings(){
        System.out.println("settings");
    }

    private static void PreGameSettings() {
        mainWindowState = MainWindowState.PLAYER_SELECTION;
        gameConfig = new GameConfig();
        ActionListener one_player_gameListener = e -> DisplayPlayerSelection(1);
        ActionListener two_player_gameListener = e -> DisplayPlayerSelection(2);
        ActionListener backListener = e -> ShowMainMenu();
        mainWindow.DisplayPreGameSettings(one_player_gameListener, two_player_gameListener, backListener);
    }
    private static void DisplayPlayerSelection(int players){
        mainWindowState = MainWindowState.PLAYER_COLOR_SELECTION;
        gameConfig.setPlayers(players);
        ActionListener StartGameListener = e -> StartGame(gameConfig);
        ActionListener backListener = e -> PreGameSettings();
        mainWindow.DisplayPlayerSelection(gameConfig,StartGameListener,backListener);
       }

    private static void StartGame(GameConfig config){
        mainWindowState = MainWindowState.PLAYING;
        System.out.println("Game Starting...");
        game = new Game(config,mainWindow.GetActionmap());

        mainWindow.DisplayGame(game);
    }
    public static void BugReportScreen(){
        ActionListener backListener = e -> ShowMainMenu();
        mainWindow.DisplayBugScreen(backListener); // Directly call the DisplayCredits() method
        System.out.println("bug report");
        escWindow.Close();
        escWindow = null;
    }
    public void GameTick(){
        while(game!=null){

        }
    }

} 