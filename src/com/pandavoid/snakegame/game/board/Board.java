package com.pandavoid.snakegame.game.board;

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
}
