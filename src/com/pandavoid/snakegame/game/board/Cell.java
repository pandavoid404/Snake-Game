package com.pandavoid.snakegame.game.board;

public class Cell {
	private boolean occupied;
	private boolean food;
	public Cell() {
		occupied = false;
		food = false;
	}

	public boolean isFood() {
		return food;
	}

	public void setFood(boolean food) {
		this.food = food;
	}

	public boolean isOccupied() {
		return occupied;
	}

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}
}
