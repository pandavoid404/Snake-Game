package com.pandavoid.snakegame.ui;

import com.pandavoid.snakegame.Logger;
import com.pandavoid.snakegame.Main;
import com.pandavoid.snakegame.enums.LogType;

import java.awt.*;
import java.awt.event.ActionListener;

public class EscWindow {
    private static final short HEIGHT = 500;
    private static final short WIDTH = 400;

    private final Window window;

    public EscWindow(Point MainWindowPos, int MainWindowWidth, int MainWindowHeight) {
        Logger.info(LogType.DISPLAY,"MainWindowPos: " + MainWindowPos);
        window = new Window("SnakeGame", WIDTH, HEIGHT);
        window.setBGColor();
        window.setPosition(new Point(MainWindowPos.x+MainWindowWidth/2- WIDTH /2,MainWindowPos.y+MainWindowHeight/2- HEIGHT /2));
        window.hideControls();
        ActionListener CancelListener = e-> closeEscMenu();
        ActionListener RestartListener = e-> Main.restartGame();
        ActionListener ToMainListener = e-> Main.escMenuToMainMenu();
        ActionListener BugScreenListener = e -> Main.bugReportScreen();
        window.createButton(0 ,1 ,1 ,Main.getLocaleText("escMenu.back"),CancelListener);
        window.createButton(0 ,2, 1 ,Main.getLocaleText("escMenu.restart"),RestartListener);
        window.createButton(0 ,4 ,1 ,Main.getLocaleText("escMenu.bug"),BugScreenListener);
        window.createButton(0 ,5 ,1, Main.getLocaleText("escMenu.exit"), ToMainListener);

        window.showDisplay();
    }

    private void closeEscMenu() {
        close();
        Main.getGame().resume();
    }

    public void close() {
        window.close();
        Main.disconnectEscMenu();
        Logger.debug(LogType.DISPLAY,"Closed esc menu");
    }
}
