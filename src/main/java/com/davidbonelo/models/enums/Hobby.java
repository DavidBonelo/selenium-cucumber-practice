package com.davidbonelo.models.enums;

public enum Hobby {
    SPORTS("Sports"), READING("Reading"), MUSIC("Music");

    private final String value;

    Hobby(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
