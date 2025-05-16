package com.pandavoid.snakegame.ui;

import com.pandavoid.snakegame.core.Game;
import com.pandavoid.snakegame.config.AssetConfig;

import java.util.Objects;

public class GamePanel implements Runnable {
    private final ImagePanel panel;
    private final Panel HudPanel = null;
    private Game game;

    public GamePanel() {
        panel = new ImagePanel("assets/background/gameboard/default.png", 1200, 660, 0, 1);
        panel.setLayout(null); // Use absolute positioning for ImagePanel
    }
    public void displayGame(Game game) {
        Objects.requireNonNull(game);
        this.game = game;
    }

    public AssetPaint createAsset(AssetConfig config) {
        AssetPaint assetPaint = new AssetPaint(this.game,config);
        panel.add(assetPaint);
        return assetPaint;
    }
    public void removeSnakeBlock(AssetPaint assetPaint) {
        panel.remove(assetPaint);
    }

    public ImagePanel getPanel() {
        return panel;
    }

    @Override
    public void run() {
        int targetFPS = 10;
        long targetTime = 1000 / targetFPS;
        while (game.gameRunning) {
            long startTime = System.currentTimeMillis();
            if (game != null){
                game.tick();
                panel.repaint();
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


