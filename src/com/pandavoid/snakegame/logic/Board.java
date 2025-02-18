package com.pandavoid.snakegame.logic;

public class Board {
	private Cell[][] board;
	public Board(int height, int width) {
		board = new Cell[height][width];
		for (int RI = 0; RI < height;RI++) {
			for (int CI = 0; CI < width;CI++) {
				Cell cell = new Cell();
				board[RI][CI] = cell;
			}
		}
	}
}
