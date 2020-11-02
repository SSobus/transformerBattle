package com.transformers.battle.transformers.model;

public enum TransformerType {

    AUTOBOT("A"),
    DECEPTICON("D");

    private final String abbreviation;

    TransformerType(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
