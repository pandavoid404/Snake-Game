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
        setVisible(true);
        setOpaque(true);
        for (Snake snake : game.getSnakes()) {
            if (snake != null) {
                for (SnakeCell snakeCell : snake.getSnakeCells()) {
                    repaint();
                    System.out.println("paint");
                }
            } else {
                System.out.println("snake is null");
            }
        }

    }

    @Override
    protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.red);
            g.fillRect(0, 0, Boxsize, Boxsize);
            System.out.println("paintcomponent");
            g.dispose();
    }
}

