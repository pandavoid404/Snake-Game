package com.pandavoid.snakegame;

import com.pandavoid.snakegame.enums.Difficulty;
import com.pandavoid.snakegame.enums.LogType;
import com.pandavoid.snakegame.enums.MainWindowState;
import com.pandavoid.snakegame.core.Game;
import com.pandavoid.snakegame.config.GameConfig;
import com.pandavoid.snakegame.ui.*;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.*;

public class Main {
    private static Game game;
    private static MainWindow mainWindow;
    private static GameConfig gameConfig;
    private static EscWindow escWindow;
    private static MainWindowState mainWindowState;
    private static GameOverWindow gameOverWindow;
    private static int FPS;
    private static String difficulty;

	public static void main(String[]args) {
        mainWindowState = MainWindowState.MAIN_MENU;
        ActionListener QuitListener = Main::quitGameRequest;
        ActionListener CreditsListener = e -> credits();
        ActionListener SettingsListener = e -> settings();
        ActionListener StartGameListener = e -> preGameSettings();
        mainWindow = new MainWindow(StartGameListener, SettingsListener, CreditsListener, QuitListener);
	}

    public static Game getGame(){
        return game;
    }
    public static int getFPS(){
        return FPS;
    }

    private static void showMainMenu() {
        mainWindowState = MainWindowState.MAIN_MENU;
        ActionListener QuitListener = Main::quitGameRequest;
        ActionListener CreditsListener = e -> credits();
        ActionListener SettingsListener = e -> settings();
        ActionListener StartGameListener = e -> preGameSettings();
        mainWindow.displayMenu(StartGameListener, SettingsListener, CreditsListener, QuitListener);
    }

    public static void escMenuToMainMenu() {
        closeEscMenu();
        showMainMenu();
    }

    public static void restartGame() {
        if (game != null) {
            closeGame();
            if(gameOverWindow != null) {
            gameOverWindow.close();
            }
            else if (escWindow != null) {
                escWindow.close();
            }
            startGame(gameConfig);
        } else {
            Logger.error(LogType.DISPLAY,"Game is null");
        }
    }
    public static void gameOverWindowToMainWindow() {
        closeGameOverWindow();
        closeGame();
        showMainMenu();
    }

    public static void escMenuRequest() {
        if (escWindow != null) {
            Logger.info(LogType.DISPLAY,"ESC menu found, closing menu");
            closeEscMenu();
        } else if (mainWindowState == MainWindowState.PLAYING ) {
            Logger.info(LogType.DISPLAY,"no ESC menu found, creating new ESC menu");
            Window window = mainWindow.getJavaWindow();
            game.gameRunning = false;
            escWindow = new EscWindow(window.getLocation(),window.getWidth(),window.getHeight());
        }
    }

    public static void closeEscMenu() {
        escWindow.close();
        game.gameRunning = true;
        new Thread(game.getGamePanel()).start();
        escWindow = null;
        Logger.debug(LogType.DISPLAY,"Closed esc menu");
    }

    public static void closeGameOverWindow() {
        gameOverWindow.close();
    }

    private static void quitGameRequest(ActionEvent event) {
        JButton source = (JButton) event.getSource();
        JPanel panel = (JPanel) source.getParent();
        JLayeredPane pane = (JLayeredPane) panel.getParent();
        JRootPane rootPane = (JRootPane) pane.getParent();
        Window mainwindow = (Window) rootPane.getParent();
        Logger.info(LogType.DISPLAY,"requesting to quit game");
        ActionListener QuitGameListener = e -> quitGame();
        new QuitWindow(QuitGameListener,mainwindow.getLocation(),mainwindow.getWidth(),mainwindow.getHeight());
    }

    private static void quitGame(){
        Logger.info(LogType.DISPLAY,"quiting game");
        System.exit(0);
    }

    public static void credits(){
        ActionListener backListener = e -> showMainMenu();
        mainWindow.displayCredits(backListener); // Directly call the DisplayCredits() method
        Logger.info(LogType.DISPLAY,"Opening Credits");

    }

    public static void settings(){
        ActionListener backListener = e -> showMainMenu();
        mainWindow.displaySettings(backListener);
        Logger.info(LogType.DISPLAY,"Opening Settings");
    }

    private static void preGameSettings() {
        mainWindowState = MainWindowState.PLAYER_SELECTION;
        gameConfig = new GameConfig();
        ActionListener one_player_gameListener = e -> displayPlayerSelection(1);
        ActionListener two_player_gameListener = e -> displayPlayerSelection(2);
        ActionListener backListener = e -> showMainMenu();
        mainWindow.displayPreGameSettings(one_player_gameListener, two_player_gameListener, backListener);
    }

    private static void displayPlayerSelection(int players){
        mainWindowState = MainWindowState.PLAYER_COLOR_SELECTION;
        gameConfig.setPlayers(players);
        ActionListener StartGameListener = e -> startGame(gameConfig);
        ActionListener backListener = e -> preGameSettings();
        mainWindow.displayPlayerSelection(gameConfig,StartGameListener,backListener);
    }
    private static void setDifficulty(Difficulty difficulty){
        if (difficulty == Difficulty.EASY) {
            FPS = 9;
            gameConfig.setGoldenApplesChance(15);
            gameConfig.setStartingFood(15);
        }
        if (difficulty == Difficulty.MEDIUM) {
            FPS = 12;
            gameConfig.setGoldenApplesChance(30);
            gameConfig.setStartingFood(9);
        }
        if (difficulty == Difficulty.HARD) {
            FPS = 15;
            gameConfig.setGoldenApplesChance(45);
            gameConfig.setStartingFood(6);
        }
        if (difficulty == Difficulty.INSANE) {
            FPS = 20;
            gameConfig.setGoldenApplesChance(60);
            gameConfig.setStartingFood(5);
        }
    }
    private static void startGame(GameConfig config){
        difficulty = (String) mainWindow.getwindow().getDropdown().getSelectedItem();
        setDifficulty(Difficulty.valueOf(difficulty));
        mainWindowState = MainWindowState.PLAYING;
        Logger.info(LogType.DISPLAY,"Game Starting...");
        GamePanel gamepanel = mainWindow.displayGame();
        game = new Game(config,mainWindow.getActionmap(),gamepanel);
        gamepanel.setGame(game);
        // Start the game thread to run the game loop
        Thread gameThread = new Thread(mainWindow.getGamePanel());
        gameThread.start();
    }

    public static void bugReportScreen(){
        ActionListener backListener = e -> showMainMenu();
        mainWindow.displayBugScreen(backListener); // Directly call the DisplayCredits() method
        Logger.info(LogType.DISPLAY,"Opening bug report");
        escWindow.close();
        escWindow = null;
    }

    public static void closeGame() {
        game = null;
        mainWindow.removeGamePanel();
    }

    public static void gameOverWindow(){
        Window window = mainWindow.getJavaWindow();
        gameOverWindow = new GameOverWindow(window.getLocation(),window.getWidth(),window.getHeight());
    }
} 