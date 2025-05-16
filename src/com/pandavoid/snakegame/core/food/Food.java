package com.pandavoid.snakegame.core.food;

import com.pandavoid.snakegame.core.Game;
import com.pandavoid.snakegame.ui.AssetPaint;
import com.pandavoid.snakegame.config.AssetConfig;

import java.awt.*;

public class Food {
	private Game game;
	private final AssetPaint assetPaint;
	public Food(Game game, Point position) {
		this.game = game;
		AssetConfig config = new AssetConfig();
		config.setColor(Color.decode("#AA0000"));
		config.setPosition(position);
		this.assetPaint = game.getGamePanel().createAsset(config);
		game.getBoard().getCell(position.x, position.y).setFood(this);
	}

	public AssetPaint getAssetPaint() {
		return assetPaint;
	}
}
