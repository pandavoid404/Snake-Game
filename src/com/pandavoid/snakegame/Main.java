package com.pandavoid.snakegame;

import com.pandavoid.snakegame.ui.MainWindow;
import com.pandavoid.snakegame.ui.QuitWindow;

import java.awt.event.ActionListener;

public class Main {
	public static void main(String[]args) {
        ActionListener QuitListener = e -> QuitGameRequest();
        ActionListener CreditsListener = e -> Credits();
        ActionListener SettingsListener = e -> Settings();
        ActionListener StartGameListener = e -> StartGame();
		new MainWindow(StartGameListener, SettingsListener, CreditsListener, QuitListener);

	}
    private static void QuitGameRequest() {
        System.out.println("requesting to quit game");
        ActionListener QuitGameListener = e -> QuitGame();
        new QuitWindow(QuitGameListener);
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
    private static void StartGame(){
        System.out.println("Game Starting...");
    }
} 