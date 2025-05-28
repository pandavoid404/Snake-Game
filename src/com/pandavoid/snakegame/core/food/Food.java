package com.pandavoid.snakegame.core.food;

import com.pandavoid.snakegame.core.Game;
import com.pandavoid.snakegame.ui.AssetPaint;
import com.pandavoid.snakegame.config.AssetConfig;

import java.awt.*;
import java.util.Random;

public class Food {
	private final AssetPaint assetPaint;
	private int foodval;
	private static int goldenappleChance = 0;
	public Food(Game game, Point position) {
		Random r= new Random();
		int r1 = r.nextInt(10);
		AssetConfig config = new AssetConfig();
		if (r1== goldenappleChance) {
			config.setColor(Color.decode("#AA0000"));
			config.setImagepath("assets/foreground/apple/goldenAppel.png");
			foodval = 2;
			goldenappleChance = 0;
		}else {
			config.setColor(Color.decode("#AA0000"));
			config.setImagepath("assets/foreground/apple/appel3.png");
			foodval = 1;
			goldenappleChance++;
		}
		config.setPosition(position);
		this.assetPaint = game.getGamePanel().createAsset(config);
		game.getBoard().getCell(position.x, position.y).setFood(this);
	}

	public AssetPaint getAssetPaint() {
		return assetPaint;
	}

    public int getFoodval() {
        return foodval;
    }
}
