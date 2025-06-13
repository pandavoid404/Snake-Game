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
	private FoodType foodtype;

	public Food(Game game, Point position, FoodType foodType) {
		AssetConfig config = new AssetConfig();
		this.foodtype = foodType;
		if (foodType == FoodType.goldenapple) {
			config.setColor(Color.decode("#AA0000"));
			config.setImagepath("assets/foreground/apple/goldenAppel.png");
		}else if(foodType == FoodType.apple) {
			config.setColor(Color.decode("#AA0000"));
			config.setImagepath("assets/foreground/apple/appel3.png");
		} else { throw new RuntimeException("Invalid foodType"); }
		config.setPosition(position);
		this.assetPaint = game.getGamePanel().createAsset(config);
		game.getBoard().getCell(position.x, position.y).setFood(this);

	}

	public AssetPaint getAssetPaint() {
		return assetPaint;
	}

	public FoodType getFoodType(){
		return foodtype;
	}

    public int getFoodval() {
        return foodtype.getFoodVal();
    }
}
