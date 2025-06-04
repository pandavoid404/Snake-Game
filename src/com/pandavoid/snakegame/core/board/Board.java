package com.pandavoid.snakegame.core.board;

import com.pandavoid.snakegame.Logger;
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

	public boolean isOutsideArea(int x, int y) {
		if (x < 0) {
			return true;
		}
		if (x >= WIDTH) {
			return true;
		}
		if (y < 0) {
			return true;
		}
		return y >= HEIGHT;
	}

	public Cell getCell(int x, int y) {
		return board[y][x];
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

}
