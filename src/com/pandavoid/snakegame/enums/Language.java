package com.pandavoid.snakegame.enums;

public enum Language {
    DUTCH("NL","DUTCH"),
    ENGLISH("EN","ENGLISH"),
    FRENCH("FR","FRENCH"),
    GERMAN("DE","GERMAN"),
    ITALIAN("IT","ITALIAN"),
    SPANISH("ES","SPANISH"),
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
