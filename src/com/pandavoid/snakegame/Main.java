package com.pandavoid.snakegame;

import com.pandavoid.snakegame.game.Game;
import com.pandavoid.snakegame.ui.window.MainWindow;
import com.pandavoid.snakegame.ui.window.QuitWindow;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Main {
    private static Game game;
    private static MainWindow mainWindow;
    
	public static void main(String[]args) {
        ActionListener QuitListener = Main::QuitGameRequest;
        ActionListener CreditsListener = e -> Credits();
        ActionListener SettingsListener = e -> Settings();
        ActionListener StartGameListener = e -> PreGameSettings();
        mainWindow = new MainWindow(StartGameListener, SettingsListener, CreditsListener, QuitListener);
	}

    private static void DisplayMainMenu() {
        ActionListener QuitListener = Main::QuitGameRequest;
        ActionListener CreditsListener = e -> Credits();
        ActionListener SettingsListener = e -> Settings();
        ActionListener StartGameListener = e -> PreGameSettings();
        mainWindow.DisplayMenu(StartGameListener, SettingsListener, CreditsListener, QuitListener);
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
    private static void Credits(){
        System.out.println("Credits");
    }
    private static void Settings(){
        System.out.println("settings");
    }

    private static void PreGameSettings() {
        ActionListener one_player_gameListener = e -> StartGame(1);
        ActionListener two_player_gameListener = e -> DisplayPlayerSelection(2);
        ActionListener backListener = e -> DisplayMainMenu();
        mainWindow.DisplayPreGameSettings(one_player_gameListener, two_player_gameListener, backListener);
    }
    private static void DisplayPlayerSelection(int players){
        mainWindow.DisplayPlayerSelection();
       }

    private static void StartGame(int players){
        System.out.println("Game Starting...");
        game = new Game();
    }
} 