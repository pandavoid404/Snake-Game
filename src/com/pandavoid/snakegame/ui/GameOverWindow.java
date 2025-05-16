package com.pandavoid.snakegame.ui;

import com.pandavoid.snakegame.Main;

import java.awt.*;
import java.awt.event.ActionListener;

public class GameOverWindow {
    private final Window window;
    private static final short height = 500;
    private static final short width = 400;
    private final int Players;
    private final int player1Score;
    private final int player2Score;
    public GameOverWindow(Point MainWindowPos, int MainWindowWidth, int MainWindowHeight) {
        System.out.println(MainWindowPos);
        Players = Main.getGame().getPlayers();
        player1Score = Main.getGame().getSnakes().get(0).getSnakeCells().size();
        player2Score = Main.getGame().getSnakes().get(1).getSnakeCells().size();
        window = new Window("SnakeGame", width, height);
        window.setBGColor();
        window.setPosition(new Point(MainWindowPos.x+MainWindowWidth/2-width/2,MainWindowPos.y+MainWindowHeight/2-height/2));
        window.hideControls();
        window.createLabel("Game Over", 30, 0, 0, 1);
        if (Players == 1) {
            window.createLabel("Score Player", 10, 0, 1, 1);
            window.createLabel(":"+player1Score, 10, 0, 2, 1);
        }
        else{
            window.createLabel("Score Player 1", 10, 0, 1, 1);
            window.createLabel(":"+player1Score, 10, 0, 2, 1);
            window.createLabel("Score Player 2", 10, 0, 2, 1);
            window.createLabel(":"+player2Score, 10, 0, 3, 1);
        }
        //ActionListener CancelListener = e-> Main.CloseEscMenu();
        ActionListener ToMainListener = e-> Main.gameOverWindowToMainWindow();
        window.createButton(0 ,3, 1 ,"restart",null);
        window.createButton(0 ,4 ,1, "Back to Main Menu", ToMainListener);
        window.showDisplay();
    }
    public void close() {
        window.close();
    }

}