package com.transformers.battle.transformers.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum TransformerType {

    @JsonProperty("A")
    AUTOBOT("A"),

    @JsonProperty("D")
    DECEPTICON("D");

    private final String abbreviation;

    TransformerType(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
