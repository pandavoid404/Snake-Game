package com.pandavoid.snakegame.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import com.pandavoid.snakegame.core.Game;
import com.pandavoid.snakegame.config.AssetConfig;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class AssetPaint extends JPanel {
	private final int boxsize = 20;
    private final Color color;
    private String imagePath;
    private BufferedImage image;
    public AssetPaint(Game game, AssetConfig config) {
	    Point position = config.getPosition();
        this.color = config.getColor();
        this.imagePath = config.getImagepath();
        setVisible(true);
        setOpaque(false);
        setBounds(position.x*boxsize, position.y*boxsize, boxsize, boxsize);
        repaint();
        if (imagePath != null){
            try {
                image = ImageIO.read(new File(imagePath));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g){
            super.paintComponent(g);
            if (imagePath != null) {
                g.drawImage(image, 0, 0, null);

            } else {
                g.setColor(color);
                g.fillRect(0, 0, boxsize, boxsize);
            }
            g.dispose();
    }
}

