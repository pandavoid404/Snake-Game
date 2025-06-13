package com.pandavoid.snakegame.ui;

import com.pandavoid.snakegame.Logger;
import com.pandavoid.snakegame.Main;
import com.pandavoid.snakegame.core.snake.Snake;
import com.pandavoid.snakegame.enums.LogType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameOverWindow {
    private final Window window;
    private static final short height = 600;
    private static final short width = 500;
    private final int Players;
    public GameOverWindow(Point MainWindowPos, int MainWindowWidth, int MainWindowHeight) {
        Logger.info(LogType.DISPLAY,"MainWindowPos" + MainWindowPos);
        Players = Main.getGame().getPlayers();
        window = new Window("SnakeGame", width, height);
        window.setBGColor();
        window.setPosition(new Point(MainWindowPos.x+MainWindowWidth/2-width/2,MainWindowPos.y+MainWindowHeight/2-height/2));
        window.hideControls();
        window.createLabel(Main.getLocaleText("gameOver.gameOverLabel"), 35, 0, 0, 3);
        ArrayList<Stats> statslist = new ArrayList<>();
        for (Snake snake : Main.getGame().getSnakes()) {
            statslist.add(snake.getStats());
        }
        if (Players == 1) {
            window.createLabel(Main.getLocaleText("gameOver.appleEaten")+statslist.getFirst().getApplesEaten(), 15, 0, 1, 3);
            window.createLabel(Main.getLocaleText("gameOver.goldenApplesEaten")+statslist.getFirst().getGoldenApplesEaten()+" (X2)", 15, 0, 2, 3);
            window.createLabel(Main.getLocaleText("gameOver.total")+statslist.getFirst().getTotalScore(), 15, 0, 3, 3);
        }
        else{
            int bonus1 = Main.getGame().getSnakes().get(0).getAliveBonus();
            int bonus2 = Main.getGame().getSnakes().get(1).getAliveBonus();
            int totalScore1 = bonus1+statslist.getFirst().getTotalScore();
            int totalScore2 = bonus2+statslist.getFirst().getTotalScore();
            if (totalScore1>totalScore2) {
                window.createLabel(Main.getLocaleText("gameOver.winner1"), 20, 0, 1, 3);
            }else if (totalScore2>totalScore1) {
                window.createLabel(Main.getLocaleText("gameOver.winner2"), 20, 0, 1, 3);
            }else{
                window.createLabel(Main.getLocaleText("gameOver.winnerDraw"), 20, 0, 1, 3);
            }
            window.createLabel("----------------", 15, 0, 2, 1);
            window.createLabel("----------------", 15, 2, 2, 1);
            window.createLabel(Main.getLocaleText("gameOver.player1"), 15, 0, 3, 1);
            window.createLabel("|", 15, 1, 3, 1);
            window.createLabel(Main.getLocaleText("gameOver.appleEaten")+statslist.getFirst().getApplesEaten(), 15, 0, 4, 1);
            window.createLabel("|", 15, 1, 4, 1);
            window.createLabel(Main.getLocaleText("gameOver.goldenApplesEaten")+statslist.getFirst().getGoldenApplesEaten()+"(X2)", 15, 0, 5, 1);
            if (bonus1>0) {
                window.createLabel(Main.getLocaleText("gameOver.didntDie")+bonus1, 15, 0, 6, 1);
            }else{
                window.createLabel(Main.getLocaleText("gameOver.noBonus"), 15, 0, 6, 1);
            }
            window.createLabel("|", 15, 1, 5, 1);
            window.createLabel(Main.getLocaleText("gameOver.total")+totalScore1, 15, 0, 7, 1);
            window.createLabel("|", 15, 1, 6, 1);
            window.createLabel(Main.getLocaleText("gameOver.player2"), 15, 2, 3, 1);
            window.createLabel(Main.getLocaleText("gameOver.appleEaten")+statslist.getFirst().getApplesEaten(), 15, 2, 4, 1);
            window.createLabel(Main.getLocaleText("gameOver.goldenApplesEaten")+statslist.getFirst().getGoldenApplesEaten()+"(X2)", 15, 2, 5, 1);
            window.createLabel("|", 15, 1, 7, 1);
            if (bonus2>0) {
                window.createLabel(Main.getLocaleText("gameOver.didntDie")+bonus2, 15, 2, 6, 1);
            }else{
                window.createLabel(Main.getLocaleText("gameOver.noBonus"), 15, 2, 6, 1);
            }
            window.createLabel(Main.getLocaleText("gameOver.total")+totalScore2, 15, 2, 7, 1);

        }
        ActionListener ToMainListener = e-> Main.gameOverWindowToMainWindow();
        ActionListener RestartListener = e-> Main.restartGame();
        window.createButton(0 ,9, 3,Main.getLocaleText("gameOver.restart"),RestartListener);
        window.createButton(0 ,10 ,3, Main.getLocaleText("gameOver.exit"), ToMainListener);
        window.showDisplay();
    }
    public void close() {
        window.close();
        Main.disconnectGameOverWindow();
        Logger.info(LogType.DISPLAY,"Closing Game Over Window");
    }
}