package com.pandavoid.snakegame.ui;

import com.pandavoid.snakegame.Main;

import java.awt.*;
import java.awt.event.ActionListener;

public class EscWindow {
    private static final short HEIGHT = 500;
    private static final short WIDTH = 400;

    private final Window window;

    public EscWindow(Point MainWindowPos, int MainWindowWidth, int MainWindowHeight) {
        System.out.println(MainWindowPos);
        window = new Window("SnakeGame", WIDTH, HEIGHT);
        window.setBGColor();
        window.setPosition(new Point(MainWindowPos.x+MainWindowWidth/2- WIDTH /2,MainWindowPos.y+MainWindowHeight/2- HEIGHT /2));
        window.hideControls();
        ActionListener CancelListener = e-> Main.closeEscMenu();
        ActionListener ToMainListener = e-> Main.escMenuToMainMenu();
        ActionListener SettingsListener = e -> Main.settings();
        ActionListener BugScreenListener = e -> Main.bugReportScreen();
        window.createButton(0 ,1 ,1 ,"Back to Game",CancelListener);
        window.createButton(0 ,2, 1 ,"restart",CancelListener);
        window.createButton(0 ,3 ,1 ,"Settings", SettingsListener);
        window.createButton(0 ,4 ,1 ,"Bug Report",BugScreenListener);
        window.createButton(0 ,5 ,1, "Back to Main Menu", ToMainListener);

        window.showDisplay();
    }

    public void close() {
        window.close();
    }
}
