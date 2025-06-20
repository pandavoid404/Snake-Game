package com.pandavoid.snakegame.core.board;

import com.pandavoid.snakegame.Logger;
import com.pandavoid.snakegame.core.crate.Crate;
import com.pandavoid.snakegame.enums.LogType;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Board {
	private static final int HEIGHT = 33;
	private static final int WIDTH = 60;
	private final Cell[][] board;

	public Board() {
		board = new Cell[HEIGHT][WIDTH];
		for (int RI = 0; RI < HEIGHT; RI++) {
			for (int CI = 0; CI < WIDTH; CI++) {
				Cell cell = new Cell(new Point(CI,RI));
				board[RI][CI] = cell;
			}
		}
		Logger.info(LogType.BOARD,"board generated");
	}

	public boolean isOutsideArea(Point location) {
		if (location.x < 0) {
			return true;
		}
		if (location.x >= WIDTH) {
			return true;
		}
		if (location.y < 0) {
			return true;
		}
		return location.y >= HEIGHT;
	}

	public Cell getCell(Point location) {
		return board[location.y][location.x];
	}

	public Cell findFreeCell() {
		Random random = new Random();
		ArrayList<Cell> freeCells = new ArrayList<>();
		for (Cell[] cells : board) {
			for (Cell cell : cells) {
				if (!cell.isOccupied()&&cell.getFood()==null) {
					freeCells.add(cell);
				}
			}
		}
		if (!freeCells.isEmpty()) {
			return freeCells.get(random.nextInt(freeCells.size()));
		}
		return null;
	}

	public Boolean otherCrateNearby(Point location,int radius, int blockId) {
		for (int x = location.x - radius; x <= location.x + radius; x++ ) {
			for (int y = location.y - radius; y <= location.y + radius; y++) {
				if (isOutsideArea(new Point(x, y))) {
					continue;
				}
				Crate crate = getCell(new Point(x,y)).getCrate();
				if (crate != null) {
					if (crate.getBlockId() != blockId) {
						return true;
					}
				}
			}
		}
		return false;
	}

}
