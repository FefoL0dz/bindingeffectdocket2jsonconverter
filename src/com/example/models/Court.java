package com.loganima.models;

public enum Court {
    STF("STF"), STJ("STJ");

    private final String name;

    Court(final String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.name;
    }
}