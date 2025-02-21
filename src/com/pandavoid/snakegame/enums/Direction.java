package com.pandavoid.snakegame.enums;

public enum Direction {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx; // Change in x-coordinate
    private final int dy; // Change in y-coordinate

    // Constructor
    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    // Getter methods for deltas
    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}