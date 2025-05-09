package com.pandavoid.snakegame.game.board;

import java.util.ArrayList;
import java.util.Random;

public class Board {
	private int height, width;
	private final Cell[][] board;
	public Board(int height, int width) {
		this.height = height;
		this.width = width;
		board = new Cell[height][width];
		for (int RI = 0; RI < height;RI++) {
			for (int CI = 0; CI < width;CI++) {
				Cell cell = new Cell();
				board[RI][CI] = cell;
			}
		}
		System.out.println("board generated");
	}
	public Cell GetCell(int x, int y) {
		return board[y-1][x-1];
	}

	public Cell FindFreeCell() {
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
	public boolean OutsideArea(int x, int y) {
		if (x <= 0) {
			return true;
		}
		if (x >= width) {
			return true;
		}
		if (y <= 0) {
			return true;
		}
		return y >= height;
	}
}
