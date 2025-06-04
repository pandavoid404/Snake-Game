package com.pandavoid.snakegame.ui;

import com.pandavoid.snakegame.Logger;
import com.pandavoid.snakegame.Main;
import com.pandavoid.snakegame.core.Game;
import com.pandavoid.snakegame.config.AssetConfig;
import com.pandavoid.snakegame.enums.LogType;

import java.util.Objects;

public class GamePanel implements Runnable {
    private final ImagePanel panel;
    private static int targetFPS;

    public GamePanel() {
        panel = new ImagePanel("assets/background/gameboard/default.png", 1200, 660, 0, 1);
        panel.setLayout(null);// Use absolute positioning for ImagePanel
        targetFPS = Main.getFPS();
    }

    public ImagePanel getPanel() {
        return panel;
    }

    @Override
    public void run() {
        Game game = Main.getGame();
        long targetTime = 1000 / targetFPS;
        while (game.isGameRunning()) {
            long startTime = System.currentTimeMillis();
	        game.tick();
	        panel.repaint();
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

    public AssetPaint createAsset(AssetConfig config) {
        AssetPaint assetPaint = new AssetPaint(Main.getGame(),config);
        panel.add(assetPaint);
        return assetPaint;
    }

    public void removeSnakeBlock(AssetPaint assetPaint) {
        panel.remove(assetPaint);
    }
}


