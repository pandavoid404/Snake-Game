package com.pandavoid.snakegame.interfaces;

import com.pandavoid.snakegame.Main;

import java.util.ResourceBundle;

public interface Localizable {
	void updateTexts(ResourceBundle bundle);
	default void addUpdate() {
		Main.addLocalizable(this);
	}
}
