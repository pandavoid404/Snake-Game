package com.pandavoid.snakegame.game.board;

import java.util.ArrayList;
import java.util.Random;

public class Board {
	private final Cell[][] board;
	public Board(int height, int width) {
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
		return board[y][x];
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
}
