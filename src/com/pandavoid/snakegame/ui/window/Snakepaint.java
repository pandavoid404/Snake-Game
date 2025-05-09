package com.pandavoid.snakegame.ui.window;

import javax.swing.*;
import com.pandavoid.snakegame.game.Game;
import com.pandavoid.snakegame.game.snake.Snake;
import com.pandavoid.snakegame.game.snake.SnakeCell;

import java.awt.*;

public class Snakepaint extends JPanel {
    private Game game;
    private final int boxsize = 20;
    public Snakepaint(Game game,Point position) {
        this.game = game;
        setVisible(true);
        setOpaque(true);
        setBounds(position.x*boxsize, position.y*boxsize, boxsize, boxsize);
        repaint();

    }

    @Override
    protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.red);
            g.fillRect(0, 0, boxsize, boxsize);
//            System.out.println("paintcomponent");
            g.dispose();
    }
}

