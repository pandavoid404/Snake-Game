package com.pandavoid.snakegame.ui.window;

import com.pandavoid.snakegame.game.Game;
import com.pandavoid.snakegame.game.snake.Snake;


import java.awt.*;

class GamePanel {
    private final ImagePanel panel;
    private final Game game;
    private final Snakepaint snakepaint;
    public GamePanel(Game game) {
        this.game = game;
        panel = new ImagePanel("assets/defultbackgroundsnakegameboard.png", 1200, 700, 0, 1);
        this.snakepaint = new Snakepaint(this.game);
        panel.add(snakepaint);
        if (game.getPlayers() >= 2) {
        panel.CreateLabel("score player 1: ", 0, 0, 20, game.getSnakes().get(0).getColor());
        panel.CreateLabel("score player 2: ", 1, 0, 20, game.getSnakes().get(1).getColor());
        }
        else {
            panel.CreateLabel("score player: ", 0, 0, 20, game.getSnakes().getFirst().getColor());
        }
    }

    public ImagePanel getPanel() {
        return panel;
    }
}

