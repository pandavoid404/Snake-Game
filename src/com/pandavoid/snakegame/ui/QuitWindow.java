package com.pandavoid.snakegame.ui;

import com.pandavoid.snakegame.Logger;
import com.pandavoid.snakegame.Main;
import com.pandavoid.snakegame.enums.LogType;

import java.awt.*;
import java.awt.event.ActionListener;

public class QuitWindow {
	private static final short HEIGHT = 300;
	private static final short WIDTH = 500;

	private final Window window;

	public QuitWindow(ActionListener QuitGameListener,Point MainWindowPos,int MainWindowWidth,int MainWindowHeight) {
		Logger.info(LogType.DISPLAY,"MainWindowPos" + MainWindowPos);
		window = new Window("SnakeGame", WIDTH, HEIGHT);
		window.setBGColor();
		window.setPosition(new Point(MainWindowPos.x+MainWindowWidth/2- WIDTH /2,MainWindowPos.y+MainWindowHeight/2- HEIGHT /7*2));
		window.hideControls();
		ActionListener CancelListener = e-> cancel();
		window.createButton( 0 , 40 ,1, Main.getLocaleText("quitMenu.confirm"), QuitGameListener);
		window.createButton( 10 , 40 ,1, Main.getLocaleText("quitMenu.cancel"), CancelListener);
		window.showDisplay();
	}

	private void cancel() {
		window.close();
	}
}
