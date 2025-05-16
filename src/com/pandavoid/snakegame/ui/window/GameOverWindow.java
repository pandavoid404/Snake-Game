package com.pandavoid.snakegame.ui.window;

import com.pandavoid.snakegame.Main;

import java.awt.*;
import java.awt.event.ActionListener;

public class GameOverWindow {
    private final Window window;
    private static final short height = 500;
    private static final short width = 400;
    private final int Players;
    public GameOverWindow(Point MainWindowPos, int MainWindowWidth, int MainWindowHeight) {
        System.out.println(MainWindowPos);
        Players = Main.getGame().getPlayers();
        window = new Window("SnakeGame", width, height);
        window.SetBGColor();
        window.SetPosition(new Point(MainWindowPos.x+MainWindowWidth/2-width/2,MainWindowPos.y+MainWindowHeight/2-height/2));
        window.HideControls();
        window.CreateLabel("Game Over", 20, 0, 0, 1);
        if (Players == 1) {
            window.CreateLabel("Score Player", 10, 0, 1, 1);
        }
        else{
            window.CreateLabel("Score Player 1", 10, 0, 1, 1);
            window.CreateLabel("Score Player 2", 10, 0, 2, 1);
        }
        //ActionListener CancelListener = e-> Main.CloseEscMenu();
        ActionListener ToMainListener = e-> Main.GameOverWindowToMainWindow();
        window.CreateButton(0 ,3, 1 ,"restart",null);
        window.CreateButton(0 ,4 ,1, "Back to Main Menu", ToMainListener);

        window.ShowDisplay();
    }
    public void Close() {
        window.Close();
    }

}