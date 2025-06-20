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
		CONFIG.setImagepath("assets/foreground/crates/crate_1.png");
		CONFIG.setPosition(location);
		Logger.debug(LogType.CRATE, "Crate created at location: " + location);
		game.getBoard().getCell(location).setCrate(this);
		this.assetPaint = game.getGamePanel().createAsset(CONFIG);
		ArrayList<Point> nearPoints = new ArrayList<Point>();
		nearPoints.add(new Point(location.x+1, location.y));
		nearPoints.add(new Point(location.x-1, location.y));
		nearPoints.add(new Point(location.x, location.y+1));
		nearPoints.add(new Point(location.x, location.y-1));
		Logger.debug(LogType.CRATE, "Near Points created with distance " + mainCrateDistance);
		for (Point point: nearPoints) {
			if (game.getBoard().isOutsideArea(point)) {
				Logger.debug(LogType.CRATE, "Crate spawn location outside area: " + point);
				continue;
			}
			if (game.getBoard().getCell(point).isOccupied()) {
				Logger.debug(LogType.CRATE, "Crate spawn location occupied: " + point);
				continue;
			}
			if (game.isInSnakePath(point,15,2)) {
				Logger.debug(LogType.CRATE, "Crate spawn location in snake path: " + point);
				continue;
			}
			ArrayList<Point> checkPoints = new ArrayList<Point>();
			checkPoints.add(new Point(point.x+1, point.y));
			checkPoints.add(new Point(point.x-1, point.y));
			checkPoints.add(new Point(point.x, point.y+1));
			checkPoints.add(new Point(point.x, point.y-1));
			int checkPointsOccupied = 0;
			for (Point checkPoint: checkPoints) {
				if (game.getBoard().isOutsideArea(checkPoint) || game.getBoard().getCell(checkPoint).isOccupied()) {
					checkPointsOccupied++;
				}
			}
			if (checkPointsOccupied >= 3) {
				Logger.debug(LogType.CRATE, "Crate spawn location unreachable: " + point);
				new Crate(game, point, -1);
			}
			if (game.getSpawnCrate(mainCrateDistance)) {
				Logger.debug(LogType.CRATE, "Crate spawn location spawning: " + point);
				new Crate(game, point, mainCrateDistance+1);
			}
		}
	}
}
