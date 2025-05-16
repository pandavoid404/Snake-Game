package com.pandavoid.snakegame.ui;

import java.awt.*;
import java.awt.event.ActionListener;

public class QuitWindow {
	private final Window window;
	private static final short height = 300;
	private static final short width = 500;
	public QuitWindow(ActionListener QuitGameListener,Point MainWindowPos,int MainWindowWidth,int MainWindowHeight) {
		System.out.println(MainWindowPos);
		window = new Window("SnakeGame", width, height);
		window.setBGColor();
		window.setPosition(new Point(MainWindowPos.x+MainWindowWidth/2-width/2,MainWindowPos.y+MainWindowHeight/2-height/7*2));
		window.hideControls();
		ActionListener CancelListener = e-> cancel();
		window.createButton( 0 , 40 ,1, "Quit Game", QuitGameListener);
		window.createButton( 10 , 40 ,1, "Cancel", CancelListener);
		window.showDisplay();
	}
	private void cancel() {
		window.close();
	}
}
