package com.pandavoid.snakegame.ui.window;

import javax.swing.*;
import com.pandavoid.snakegame.game.Game;
import com.pandavoid.snakegame.game.snake.Snake;

public class snakepaint extends JPanel {
    private Game game;
    public snakepaint(Game game) {
        this.game = game;
        for (Snake snake : game.getSnakes()) {

        }
    }
}
