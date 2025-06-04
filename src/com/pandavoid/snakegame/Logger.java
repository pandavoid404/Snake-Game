package com.pandavoid.snakegame;

import com.pandavoid.snakegame.enums.LogLevel;
import com.pandavoid.snakegame.enums.LogType;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Logger {
	private static final List<LogType> EnabledDebugLogTypes = List.of(LogType.TICK,LogType.DISPLAY);

	private static void sendLog(LogType type, LogLevel level, String message) {
		LocalDateTime now = LocalDateTime.now();
		String formatted = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
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
}
