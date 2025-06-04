package com.pandavoid.snakegame.core.food;

import com.pandavoid.snakegame.Logger;
import com.pandavoid.snakegame.core.Game;
import com.pandavoid.snakegame.enums.FoodType;
import com.pandavoid.snakegame.enums.LogType;
import com.pandavoid.snakegame.ui.AssetPaint;
import com.pandavoid.snakegame.config.AssetConfig;

import java.awt.*;
import java.util.Random;

public class Food {
	private final AssetPaint assetPaint;
	private int foodval;

	public Food(Game game, Point position, FoodType foodType) {
		AssetConfig config = new AssetConfig();
		if (foodType == FoodType.goldenapple) {
			config.setColor(Color.decode("#AA0000"));
			config.setImagepath("assets/foreground/apple/goldenAppel.png");
			foodval = foodType.getFoodVal();
			Logger.info(LogType.APPLE,"goldenapple generated");
		}else if(foodType == FoodType.apple) {
			config.setColor(Color.decode("#AA0000"));
			config.setImagepath("assets/foreground/apple/appel3.png");
			foodval = foodType.getFoodVal();
		} else { throw new RuntimeException("Invalid foodType"); }
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
