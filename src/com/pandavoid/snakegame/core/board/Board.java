package com.pandavoid.snakegame.core.board;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Board {
	private final int height;
	private final int width;
	private final Cell[][] board;
	public Board(int height, int width) {
		this.height = height;
		this.width = width;
		board = new Cell[height][width];
		for (int RI = 0; RI < height;RI++) {
			for (int CI = 0; CI < width;CI++) {
				Cell cell = new Cell(new Point(CI,RI));
				board[RI][CI] = cell;
			}
		}
		System.out.println("board generated");
	}
	public boolean isOutsideArea(int x, int y) {
		if (x < 0) {
			return true;
		}
		if (x >= width) {
			return true;
		}
		if (y < 0) {
			return true;
		}
		return y >= height;
	}

	public Cell getCell(int x, int y) {
		return board[y][x];
	}

	public Cell findFreeCell() {
		Random random = new Random();
		ArrayList<Cell> freeCells = new ArrayList<>();
		for (Cell[] cells : board) {
			for (Cell cell : cells) {
				if (!cell.isOccupied()) {
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
