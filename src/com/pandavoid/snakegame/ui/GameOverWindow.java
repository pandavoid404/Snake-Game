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
        window.createLabel("Game Over", 35, 0, 0, 3);
        if (Players == 1) {
            int Score1 = Main.getGame().getSnakes().get(0).getScore();
            window.createLabel("Score:"+Score1, 15, 0, 1, 2);
        }
        else{
            int bonus1 = Main.getGame().getSnakes().get(0).getAliveBonus();
            int bonus2 = Main.getGame().getSnakes().get(1).getAliveBonus();
            int Score1 = Main.getGame().getSnakes().get(0).getScore();
            int Score2 = Main.getGame().getSnakes().get(1).getScore();
            int totalScore1 = bonus1+Score1;
            int totalScore2 = bonus2+Score2;
            if (totalScore1>totalScore2) {
                window.createLabel("Winner: Player1", 20, 0, 1, 3);
            }else if (totalScore2>totalScore1) {
                window.createLabel("Winner: Player2", 20, 0, 1, 3);
            }else {
                window.createLabel("Draw", 20, 0, 1, 3);
            }
            window.createLabel("----------------", 15, 0, 2, 1);
            window.createLabel("----------------", 15, 2, 2, 1);
            window.createLabel("Player1", 15, 0, 3, 1);
            window.createLabel("|", 15, 1, 3, 1);
            window.createLabel("Appels gegeten:"+Score1, 15, 0, 4, 1);
            window.createLabel("|", 15, 1, 4, 1);
            if (bonus1>0) {
                window.createLabel("didn't die bonus:"+bonus1, 15, 0, 5, 1);
            }else{
                window.createLabel("no bonus", 15, 0, 5, 1);
            }
            window.createLabel("|", 15, 1, 5, 1);
            window.createLabel("total:"+totalScore1, 15, 0, 6, 1);
            window.createLabel("|", 15, 1, 6, 1);
            window.createLabel("Player2", 15, 2, 3, 1);
            window.createLabel("Appels gegeten:"+Score2, 15, 2, 4, 1);
            if (bonus2>0) {
                window.createLabel("didn't die bonus:"+bonus2, 15, 2, 5, 1);
            }else{
                window.createLabel("no bonus", 15, 2, 5, 1);
            }
            window.createLabel("total:"+totalScore2, 15, 2, 6, 1);

        }
        ActionListener ToMainListener = e-> Main.gameOverWindowToMainWindow();
        ActionListener RestartListener = e-> Main.restartGame();
        window.createButton(0 ,9, 3,"restart",RestartListener);
        window.createButton(0 ,10 ,3, "Back to Main Menu", ToMainListener);
        window.showDisplay();
    }
    public void close() {
        window.close();
    }
}