package com.pandavoid.snakegame;

import com.pandavoid.snakegame.enums.Difficulty;
import com.pandavoid.snakegame.enums.Language;
import com.pandavoid.snakegame.enums.LogType;
import com.pandavoid.snakegame.enums.MainWindowState;
import com.pandavoid.snakegame.core.Game;
import com.pandavoid.snakegame.config.GameConfig;
import com.pandavoid.snakegame.ui.*;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.*;

public class Main {
    private static Locale locale;
    private static ResourceBundle messages;
    private static Game game;
    private static MainWindow mainWindow;
    private static GameConfig gameConfig;
    private static EscWindow escWindow;
    private static MainWindowState mainWindowState;
    private static GameOverWindow gameOverWindow;
    private static int FPS;
    private static String difficulty;
    private static JComboBox languagedropdown;

	public static void main(String[]args) {
        setLanguage(Language.ENGLISH);
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

    public static void setLanguage(Language language){
        locale = Locale.of(language.getLocale());
        messages = ResourceBundle.getBundle("lang.messages", locale);
    }

    public static String getLocaleText(String message){
        return messages.getString(message);
    }
    private static void showMainMenu() {
        languagedropdown = mainWindow.getLanguagedropdown();
        if(languagedropdown == null){
            setLanguage(Language.ENGLISH);
        }else {
            setLanguage(Language.valueOf(languagedropdown.getSelectedItem().toString()));
        }
        mainWindowState = MainWindowState.MAIN_MENU;
        ActionListener QuitListener = Main::quitGameRequest;
        ActionListener CreditsListener = e -> credits();
        ActionListener SettingsListener = e -> settings();
        ActionListener StartGameListener = e -> preGameSettings();
        mainWindow.displayMenu(StartGameListener, SettingsListener, CreditsListener, QuitListener);
    }

    public static void escMenuToMainMenu() {
        escWindow.close();
        closeGame();
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
        gameOverWindow.close();
        closeGame();
        showMainMenu();
    }

    public static void escMenuRequest() {
        if (escWindow != null) {
            Logger.info(LogType.DISPLAY,"ESC menu found, closing menu");
            escWindow.close();
        } else if (mainWindowState == MainWindowState.PLAYING ) {
            Logger.info(LogType.DISPLAY,"no ESC menu found, creating new ESC menu");
            Window window = mainWindow.getJavaWindow();
            game.pause();
            escWindow = new EscWindow(window.getLocation(),window.getWidth(),window.getHeight());
        }
    }
    public static void disconnectEscMenu() {
        escWindow = null;
    }

    public static void disconnectGameOverWindow() {
        gameOverWindow = null;
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
            gameConfig.setCratesAmount(5);
            gameConfig.setCratesBaseChance(60);
            gameConfig.setCratesDecreaseChance(10);

        }
        if (difficulty == Difficulty.MEDIUM) {
            FPS = 12;
            gameConfig.setGoldenApplesChance(30);
            gameConfig.setStartingFood(9);
            gameConfig.setCratesAmount(10);
            gameConfig.setCratesBaseChance(70);
            gameConfig.setCratesDecreaseChance(15);
        }
        if (difficulty == Difficulty.HARD) {
            FPS = 15;
            gameConfig.setGoldenApplesChance(45);
            gameConfig.setStartingFood(7);
            gameConfig.setCratesAmount(6);
            gameConfig.setCratesBaseChance(100);
            gameConfig.setCratesDecreaseChance(10);
        }
        if (difficulty == Difficulty.INSANE) {
            FPS = 20;
            gameConfig.setGoldenApplesChance(60);
            gameConfig.setStartingFood(5);
            gameConfig.setCratesAmount(5);
            gameConfig.setCratesBaseChance(140);
            gameConfig.setCratesDecreaseChance(10);
        }
    }
    private static void startGame(GameConfig config){
        difficulty = (String) mainWindow.getDifficultydropdown().getSelectedItem();
        boolean cratesEnabled = mainWindow.getToggleButton().isSelected();
        gameConfig.setCratesEnabled(cratesEnabled);
        setDifficulty(Difficulty.valueOf(difficulty));
        mainWindowState = MainWindowState.PLAYING;
        Logger.info(LogType.DISPLAY,"Game Starting...");
        GamePanel gamepanel = mainWindow.displayGame();
        game = new Game(config,mainWindow.getActionmap(),gamepanel);
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
        Logger.info(LogType.DISPLAY,"Closing game");
        game.pause();
        game = null;
        mainWindow.removeGamePanel();
    }

    public static void gameOverWindow(){
        Logger.info(LogType.DISPLAY,"Opening Game Over");
        Window window = mainWindow.getJavaWindow();
        gameOverWindow = new GameOverWindow(window.getLocation(),window.getWidth(),window.getHeight());
    }
} 