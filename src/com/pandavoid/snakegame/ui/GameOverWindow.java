package com.pandavoid.snakegame.ui;

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
        window.setBGColor();
        window.setPosition(new Point(MainWindowPos.x+MainWindowWidth/2-width/2,MainWindowPos.y+MainWindowHeight/2-height/2));
        window.hideControls();
        window.createLabel("Game Over", 30, 0, 0, 1);
        if (Players == 1) {
            int Score1 = Main.getGame().getSnakes().get(0).getScore();
            window.createLabel("Score:"+Score1, 15, 0, 1, 1);
        }
        else{
            int Score1 = Main.getGame().getSnakes().get(0).getScore();
            int Score2 = Main.getGame().getSnakes().get(1).getScore();
            window.createLabel("Score Player 1:"+Score1, 15, 0, 1, 1);
            window.createLabel("Score Player 2:"+Score2, 15, 0, 2, 1);

        }
        ActionListener ToMainListener = e-> Main.gameOverWindowToMainWindow();
        window.createButton(0 ,3, 1,"restart",null);
        window.createButton(0 ,4 ,1, "Back to Main Menu", ToMainListener);
        window.showDisplay();
    }
    public void close() {
        window.close();
    }
}