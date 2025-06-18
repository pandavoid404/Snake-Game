package com.pandavoid.snakegame.core.crate;

import com.pandavoid.snakegame.Logger;
import com.pandavoid.snakegame.config.AssetConfig;
import com.pandavoid.snakegame.core.Game;
import com.pandavoid.snakegame.enums.LogType;
import com.pandavoid.snakegame.ui.AssetPaint;

import java.awt.*;
import java.util.ArrayList;

public class Crate {
	private static final AssetConfig CONFIG = new AssetConfig();
	private final AssetPaint assetPaint;
	public Crate(Game game, Point location, int mainCrateDistance) {
		CONFIG.setColor(Color.orange);
		CONFIG.setPosition(location);
		Logger.debug(LogType.CRATE, "Crate created");
		game.getBoard().getCell(location).setCrate(this);
		ArrayList<Point> nearPoints = new ArrayList<Point>();
		nearPoints.add(new Point(location.x+1, location.y));
		nearPoints.add(new Point(location.x-1, location.y));
		nearPoints.add(new Point(location.x, location.y+1));
		nearPoints.add(new Point(location.x, location.y-1));
		for (Point point: nearPoints) {
			if (game.getBoard().isOutsideArea(point) && game.getSpawnCrate(mainCrateDistance)) {
				new Crate(game, point, mainCrateDistance+1);
			}
		}
		this.assetPaint = game.getGamePanel().createAsset(CONFIG);
	}
}
