package com.transformers.battle.transformers;

import com.transformers.battle.transformers.model.Transformer;
import com.transformers.battle.transformers.model.TransformerType;

public class TransformerGenerator {

    public static Transformer initializeTransformer(String name, TransformerType type, Integer strength, Integer intelligence, Integer speed, Integer endurance, Integer rank, Integer courage, Integer firepower) {
        Transformer transformer = new Transformer();

        transformer.setId(Long.valueOf(1));

        transformer.setName(name);
        transformer.setType(type);
        transformer.setStrength(strength);
        transformer.setIntelligence(intelligence);
        transformer.setSpeed(speed);
        transformer.setEndurance(endurance);
        transformer.setRank(rank);
        transformer.setCourage(courage);
        transformer.setFirepower(firepower);

        transformer.setSkill(transformer.determineSkill());

        return transformer;
    }

    public static Transformer initializeTransformerNoId(String name, TransformerType type, Integer strength, Integer intelligence, Integer speed, Integer endurance, Integer rank, Integer courage, Integer firepower) {
        Transformer transformer = new Transformer();

        transformer.setName(name);
        transformer.setType(type);
        transformer.setStrength(strength);
        transformer.setIntelligence(intelligence);
        transformer.setSpeed(speed);
        transformer.setEndurance(endurance);
        transformer.setRank(rank);
        transformer.setCourage(courage);
        transformer.setFirepower(firepower);

        transformer.setSkill(transformer.determineSkill());

        return transformer;
    }
}
