package com.pandavoid.snakegame.ui.window;

import com.pandavoid.snakegame.Main;

import java.awt.*;
import java.awt.event.ActionListener;

public class EscWindow {
    private final Window window;
    private static final short height = 500;
    private static final short width = 400;
    public EscWindow(Point MainWindowPos, int MainWindowWidth, int MainWindowHeight) {
        System.out.println(MainWindowPos);
        window = new Window("SnakeGame", width, height);
        window.SetBGColor();
        window.SetPosition(new Point(MainWindowPos.x+MainWindowWidth/2-width/2,MainWindowPos.y+MainWindowHeight/2-height/2));
        window.HideControls();
        ActionListener CancelListener = e-> Main.CloseEscMenu();
        ActionListener ToMainListener = e-> Main.EscMenuToMainMenu();
        ActionListener SettingsListener = e -> Main.Settings();
        ActionListener BugScreenListener = e -> Main.BugReportScreen();
        window.CreateButton(0 ,1 ,1 ,"Back to Game",CancelListener);
        window.CreateButton(0 ,2, 1 ,"restart",CancelListener);
        window.CreateButton(0 ,3 ,1 ,"Settings", SettingsListener);
        window.CreateButton(0 ,4 ,1 ,"Bug Report",BugScreenListener);
        window.CreateButton(0 ,5 ,1, "Back to Main Menu", ToMainListener);

        window.ShowDisplay();
    }
    public void Close() {
        window.Close();
    }

}
