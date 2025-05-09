package com.pandavoid.snakegame.ui.window;

import com.pandavoid.snakegame.enums.Direction;
import com.pandavoid.snakegame.game.Game;

class GamePanel {
    private final ImagePanel panel;
    private final Panel HudPanel = null;
    private final Game game;
    private final Snakepaint snakepaint;
    private final Snakepaint snakepaint2;
    private static int Xofset = 120;
    private static int Yofset = 520;
    private static final int boxsize = 20;
    public GamePanel(Game game) {
        this.game = game;
        panel = new ImagePanel("assets/defultbackgroundsnakegameboard.png", 1200, 660, 0, 1);
        this.snakepaint = new Snakepaint(this.game);
        snakepaint.setBounds(Xofset, Yofset, boxsize, boxsize); // Set initial size and position
        panel.setLayout(null); // Use absolute positioning for ImagePanel
        panel.add(snakepaint);

        this.snakepaint2 = new Snakepaint(this.game);
        snakepaint2.setBounds(Xofset, Yofset+20, boxsize, boxsize); // Set initial size and position
        panel.add(snakepaint2);

    }
    public ImagePanel getPanel() {
        return panel;
    }
}

