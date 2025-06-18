package com.pandavoid.snakegame.core.crate;

import com.pandavoid.snakegame.core.Game;

import java.awt.*;
import java.util.ArrayList;

public class Crate {
	public Crate(Game game, Point location, int mainCrateDistance) {
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
	}
}
