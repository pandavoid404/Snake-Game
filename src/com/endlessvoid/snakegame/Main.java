package com.endlessvoid.snakegame;

import com.endlessvoid.snakegame.ui.MainWindow;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[]args) {

        ActionListener QuitListener = e -> quitGame();
        ActionListener CreditsListener = e -> Credits();
        ActionListener SettingsListener = e -> Settings();
        ActionListener StartGameListener = e -> StartGame();
        MainWindow mainWindow = new MainWindow(StartGameListener,SettingsListener,CreditsListener,QuitListener);

    }
    private static void quitGame(){
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