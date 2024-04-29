package com.davidbonelo.models.enums;

public enum Gender {
    MALE("Male"), FEMALE("Female"), OTHER("Other");

    private final String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
