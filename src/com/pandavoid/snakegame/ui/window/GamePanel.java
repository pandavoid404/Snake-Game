package com.pandavoid.snakegame.ui.window;

import com.pandavoid.snakegame.enums.Direction;
import com.pandavoid.snakegame.game.Game;

import java.awt.*;

public class GamePanel {
    private final ImagePanel panel;
    private final Panel HudPanel = null;
    private final Game game;
    public GamePanel(Game game) {
        this.game = game;
        panel = new ImagePanel("assets/defultbackgroundsnakegameboard.png", 1200, 660, 0, 1);
        panel.setLayout(null); // Use absolute positioning for ImagePanel
    }
    public Snakepaint createSnakeBlock(Point position) {
        Snakepaint snakepaint = new Snakepaint(this.game,position);
        panel.add(snakepaint);
        return snakepaint;
    }
    public ImagePanel getPanel() {
        return panel;
    }
}

