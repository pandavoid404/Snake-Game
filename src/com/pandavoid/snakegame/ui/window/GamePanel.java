package com.pandavoid.snakegame.ui.window;

import com.pandavoid.snakegame.game.Game;

class GamePanel {
    private final ImagePanel panel;
    private final Panel HudPanel = null;
    private final Game game;
    private final Snakepaint snakepaint;
    public GamePanel(Game game) {
        this.game = game;
        panel = new ImagePanel("assets/defultbackgroundsnakegameboard.png", 1200, 700, 0, 1);
        this.snakepaint = new Snakepaint(this.game);
        snakepaint.setBounds(100, 400, 20, 20); // Set initial size and position
        snakepaint.setVisible(true); // Ensure visibility
        snakepaint.setOpaque(true);
        panel.setLayout(null); // Use absolute positioning for ImagePanel
        panel.add(snakepaint);
    }

    public ImagePanel getPanel() {
        return panel;
    }
}

