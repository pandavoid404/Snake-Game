package com.pandavoid.snakegame.enums;

public enum FoodType {
    apple(1),
    goldenapple(2);

    private final int foodVal;

    FoodType(int foodVal) {
        this.foodVal = foodVal;
    }

    public int getFoodVal() {
        return foodVal;
    }
}
