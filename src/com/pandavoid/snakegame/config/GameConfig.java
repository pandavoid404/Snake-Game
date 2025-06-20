package com.pandavoid.snakegame.config;

import java.awt.*;

public class GameConfig {
	private static final Color[] COLORS = {
			new Color(0, 0, 139),
			Color.RED,
			new Color(0, 100, 0),
			Color.MAGENTA,
			new Color(255, 140, 0),
			new Color(128, 0, 128)};

	private final PlayerConfig[] playerConfigs = new PlayerConfig[2];

	private int players;
	private int startingFood = 5;
	private int goldenApplesChance = 5;
	private boolean CratesEnabled;
	private int cratesAmount;
	private int cratesBaseChance;
	private int cratesDecreaseChance;
	public GameConfig() {
		players = 1;
	}

	public Color[] getColors() {
		return COLORS;
	}

	public PlayerConfig getPlayerConfig(int player) {
		return playerConfigs[player];
	}

	public int getPlayers() {
		return players;
	}

	public int getStartingFood() {
		return startingFood;
	}

	public void setPlayers(int amount) {
		players = amount;
		playerConfigs[0] = new PlayerConfig(this);
		playerConfigs[0].setPosition(new Point(5, 30));
		if (players == 1) {
			playerConfigs[1] = null;
		} else if (players == 2) {
			playerConfigs[1] = new PlayerConfig(this);
			playerConfigs[1].setPosition(new Point(55, 30));
		}
	}

	public void setStartingFood(int startingFood) {
		this.startingFood = startingFood;
	}

    public int getGoldenApplesChance() {
        return goldenApplesChance;
    }

    public void setGoldenApplesChance(int goldenApplesChance) {
        this.goldenApplesChance = goldenApplesChance;
    }

    public boolean getCratesEnabled() {
        return CratesEnabled;
    }

    public void setCratesEnabled(boolean cratesEnabled) {
        CratesEnabled = cratesEnabled;
    }

    public int getCratesAmount() {
        return cratesAmount;
    }

    public void setCratesAmount(int cratesAmount) {
        this.cratesAmount = cratesAmount;
    }

    public int getCratesBaseChance() {
        return cratesBaseChance;
    }

    public void setCratesBaseChance(int cratesBaseChance) {
        this.cratesBaseChance = cratesBaseChance;
    }

    public int getCratesDecreaseChance() {
        return cratesDecreaseChance;
    }

    public void setCratesDecreaseChance(int cratesDecreaseChance) {
        this.cratesDecreaseChance = cratesDecreaseChance;
    }
}
