package com.pandavoid.snakegame.ui.window;

import javax.swing.*;
import com.pandavoid.snakegame.game.Game;
import com.pandavoid.snakegame.game.snake.Snake;
import com.pandavoid.snakegame.game.snake.SnakeCell;

import java.awt.*;

public class Snakepaint extends JPanel {
    private Game game;
    private final int Boxsize = 27;
    public Snakepaint(Game game) {
        this.game = game;
        for (Snake snake : game.getSnakes()) {
            for (SnakeCell snakeCell : snake.getSnakeCells()) {
                repaint();
            }
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.red);
        g.fillRect(100,100,Boxsize,Boxsize);
    }
}
