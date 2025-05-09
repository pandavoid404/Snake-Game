package com.pandavoid.snakegame.ui.window;

import com.pandavoid.snakegame.enums.Direction;
import com.pandavoid.snakegame.game.Game;

class GamePanel {
    private final ImagePanel panel;
    private final Panel HudPanel = null;
    private final Game game;
    private final Snakepaint snakepaint;
    private static int Xofset = 0;
    private static int Yofset = 0;
    private static final int boxsize = 20;
    public GamePanel(Game game) {
        this.game = game;
        panel = new ImagePanel("assets/defultbackgroundsnakegameboard.png", 1200, 700, 0, 1);
        this.snakepaint = new Snakepaint(this.game);
        snakepaint.setBounds(Xofset, Yofset, boxsize, boxsize); // Set initial size and position
        snakepaint.setVisible(true); // Ensure visibility
        snakepaint.setOpaque(true);
        panel.setLayout(null); // Use absolute positioning for ImagePanel
        panel.add(snakepaint);
    }
    public void Move(Direction direction) {
        switch (direction) {
            case UP:
                Yofset-=boxsize;
                break;
            case DOWN:
                Yofset+=boxsize;
                break;
            case LEFT:
                Xofset-=boxsize;
                break;
            case RIGHT:
                Xofset+=boxsize;
                break;
        }
        snakepaint.setBounds(Xofset, Yofset, boxsize, boxsize);
    }

    public ImagePanel getPanel() {
        return panel;
    }
}

