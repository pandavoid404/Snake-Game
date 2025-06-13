package com.pandavoid.snakegame.ui;

import com.pandavoid.snakegame.enums.FoodType;

public class Stats {
    private int goldenApplesEaten = 0;
    private int applesEaten = 0;
    private int totalScore;

    public Stats() {

    }

    public void appleEaten(FoodType foodType) {
        totalScore += foodType.getFoodVal();
        if (foodType == FoodType.apple) {
            applesEaten++;
        } else if (foodType == FoodType.goldenapple) {
            goldenApplesEaten++;
        }
    }

    public int getGoldenApplesEaten() {
        return goldenApplesEaten;
    }

    public int getApplesEaten() {
        return applesEaten;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
