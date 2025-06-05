package com.pandavoid.snakegame;

import com.pandavoid.snakegame.enums.LogLevel;
import com.pandavoid.snakegame.enums.LogType;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Logger {
	private static final List<LogType> EnabledDebugLogTypes = List.of(LogType.DISPLAY,LogType.APPLE);
	private static int currentTick = 0;
	private static boolean tickMessageSent = false;

	private static void sendLog(LogType type, LogLevel level, String message) {
		LocalDateTime now = LocalDateTime.now();
		String formatted = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
		if (!tickMessageSent && !type.equals(LogType.TICK)) {
			tickMessageSent = true;
			System.out.println("[SnakeGame] [" + formatted + "] [" + LogType.TICK + "] " + LogLevel.INFO + ": Activity in Tick: " + currentTick);
		}
		System.out.println("[SnakeGame] [" + formatted + "] [" + type + "] " + level + ": " + message);
	}
	public static void debug(LogType type, String message) {
		if (EnabledDebugLogTypes.contains(type)) {
			sendLog(type, LogLevel.DEBUG, message);
		}
	}
	public static void info(LogType logType, String message) {
		sendLog(logType,LogLevel.INFO,message);
	}

	public static void warn(LogType logType, String message) {
		sendLog(logType,LogLevel.WARN,message);
	}
	public static void error(LogType logType, String message) {
		sendLog(logType,LogLevel.ERROR,message);
	}

	public static void setTick(int tick) {
		currentTick = tick;
		tickMessageSent = false;
	}
}
