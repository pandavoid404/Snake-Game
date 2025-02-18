package com.pandavoid.snakegame.ui;

import java.awt.*;
import java.awt.event.ActionListener;

public class QuitWindow {
	private final Window window;
	private static final short height = 300;
	private static final short width = 400;
	public QuitWindow(ActionListener QuitGameListener,Point MainWindowPos,int MainWindowWidth,int MainWindowHeight) {
		System.out.println(MainWindowPos);
		window = new Window("SnakeGame", width, height);
		window.SetBGColor(Color.BLUE);
		window.SetPosition(new Point(MainWindowPos.x+MainWindowWidth/2-width/2,MainWindowPos.y+MainWindowHeight/2-height/6*2));
		window.HideControls(true);
		ActionListener CancelListener = e-> Cancel();
		window.CreateButton( 0 , 40 , "Quit Game", Color.BLACK, Color.WHITE , QuitGameListener);
		window.CreateButton( 10 , 40 , "Cancel", Color.BLACK, Color.WHITE , CancelListener);
		window.ShowDisplay();
	}
	private void Cancel() {
		window.Close();
	}
}
