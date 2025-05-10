package com.pandavoid.snakegame.ui.window;

import javax.swing.*;
import com.pandavoid.snakegame.game.Game;
import com.pandavoid.snakegame.ui.window.config.AssetConfig;

import java.awt.*;

public class AssetPaint extends JPanel {
    private Game game;
    private final int boxsize = 20;
    private final Color color;
    public AssetPaint(Game game, AssetConfig config) {
        this.game = game;
        Point position = config.getPosition();
        this.color = config.getColor();
        setVisible(true);
        setOpaque(true);
        setBounds(position.x*boxsize, position.y*boxsize, boxsize, boxsize);
        repaint();

    }

    @Override
    protected void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(color);
            g.fillRect(0, 0, boxsize, boxsize);
//            System.out.println("paintcomponent");
            g.dispose();
    }
}

