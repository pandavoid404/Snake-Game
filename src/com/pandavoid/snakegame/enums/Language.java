package com.pandavoid.snakegame.enums;

public enum Language {
    DUTCH("NL","NEDERLANDS"),
    ENGLISH("EN","ENGLISH"),
    FRENCH("FR","FRANÇAIS"),
    GERMAN("DE","DEUTSCH"),
    JAPANESE("JA","日本語"),
    KOREAN("KO","한국어"),
    CHINESE("ZH-CN","简体中文"),
    ITALIAN("IT","ITALIANO")
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
