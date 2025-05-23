package com.pandavoid.snakegame.ui;

import javax.swing.*;
import com.pandavoid.snakegame.core.Game;
import com.pandavoid.snakegame.config.AssetConfig;

import java.awt.*;

public class AssetPaint extends JPanel {
	private final int boxsize = 20;
    private final Color color;

    public AssetPaint(Game game, AssetConfig config) {
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
            g.dispose();
    }
}

