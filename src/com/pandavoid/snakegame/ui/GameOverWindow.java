package com.pandavoid.snakegame.ui;

import com.pandavoid.snakegame.Main;

import java.awt.*;
import java.awt.event.ActionListener;

public class GameOverWindow {
    private static final short HEIGHT = 500;
    private static final short WIDTH = 400;

    private final Window window;

	public GameOverWindow(Point MainWindowPos, int MainWindowWidth, int MainWindowHeight) {
        System.out.println(MainWindowPos);
		int players = Main.getGame().getPlayers();
        window = new Window("SnakeGame", WIDTH, HEIGHT);
        window.setBGColor();
        window.setPosition(new Point(MainWindowPos.x+MainWindowWidth/2- WIDTH /2,MainWindowPos.y+MainWindowHeight/2- HEIGHT /2));
        window.hideControls();
        window.createLabel("Game Over", 30, 0, 0, 1);
        if (players == 1) {
            window.createLabel("Score Player", 10, 0, 1, 1);
        }
        else{
            window.createLabel("Score Player 1", 10, 0, 1, 1);
            window.createLabel("Score Player 2", 10, 0, 2, 1);
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