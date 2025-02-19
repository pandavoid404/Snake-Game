package com.pandavoid.snakegame.ui.window;

import java.awt.*;
import java.awt.event.ActionListener;

public class QuitWindow {
	private final Window window;
	private static final short height = 300;
	private static final short width = 500;
	public QuitWindow(ActionListener QuitGameListener,Point MainWindowPos,int MainWindowWidth,int MainWindowHeight) {
		System.out.println(MainWindowPos);
		window = new Window("SnakeGame", width, height);
		window.SetBGColor(Color.WHITE);
		window.SetPosition(new Point(MainWindowPos.x+MainWindowWidth/2-width/2,MainWindowPos.y+MainWindowHeight/2-height/7*2));
		window.HideControls(true);
		ActionListener CancelListener = e-> Cancel();
		window.CreateButton( 0 , 40 ,1, "Quit Game", QuitGameListener);
		window.CreateButton( 10 , 40 ,1, "Cancel", CancelListener);
		window.ShowDisplay();
	}
	private void Cancel() {
		window.Close();
	}
}
