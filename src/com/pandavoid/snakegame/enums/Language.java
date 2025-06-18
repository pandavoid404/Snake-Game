package com.pandavoid.snakegame.enums;

public enum Language {
    ENGLISH("EN", "ENGLISH"),
    DUTCH("NL", "DUTCH"),
    FRENCH("FR", "FRENCH"),
    GERMAN("DE", "GERMAN"),
    ITALIAN("IT", "ITALIAN"),
    SPANISH("ES", "SPANISH"),
    POLISH("PL", "POLISH"),
    INDONESIAN("ID", "INDONESIAN"),
    ;
    private final String locale;
    private final String languageName;

    Language(String locale, String languageName) {
        this.locale = locale;
        this.languageName = languageName;
    }

    public String getLocale() {
        return locale;
    }

    public String getLanguageName() {
        return languageName;
    }
}