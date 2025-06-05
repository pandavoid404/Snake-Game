package com.pandavoid.snakegame.enums;

public enum Language {
    Dutch("NL","NEDERLANDS"),
    English("EN","ENGLISH"),
    French("FR","Français"),
    GERMAN("DE","DEUTSCH"),
    JAPANESE("JA","日本語"),
    KOREAN("KO","한국어"),
    CHINESE("ZH-CN","简体中文"),
    ITALIAN("IT","ITALIANO"),
    POLISH("PO","POLSKI")
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
