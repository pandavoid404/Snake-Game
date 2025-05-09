package com.pandavoid.snakegame.ui.window;

import com.pandavoid.snakegame.enums.Direction;
import com.pandavoid.snakegame.game.Game;

import java.awt.*;

public class GamePanel implements Runnable {
    private final ImagePanel panel;
    private final Panel HudPanel = null;
    private Game game;

    public GamePanel() {
        panel = new ImagePanel("assets/defultbackgroundsnakegameboard.png", 1200, 660, 0, 1);
        panel.setLayout(null); // Use absolute positioning for ImagePanel
    }
    public void DisplayGame(Game game) {
        Objects.requireNonNull(game);
        this.game = game;
    }

    public Snakepaint createSnakeBlock(Point position) {
        Snakepaint snakepaint = new Snakepaint(this.game, position);
        panel.add(snakepaint);
        return snakepaint;
    }

    public ImagePanel getPanel() {
        return panel;
    }

    @Override
    public void run() {
        int targetFPS = 60;
        long targetTime = 1000 / targetFPS;
        while (true) {
            long startTime = System.currentTimeMillis();
            if (game != null){
                game.tick();
            } else {
                System.out.println("Game is null");
            }
            long elapsedTime = System.currentTimeMillis() - startTime;
            if (elapsedTime < targetTime) {
                try {
                    Thread.sleep(targetTime - elapsedTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


