package com.transformers.battle.transformers.model;


import org.jetbrains.annotations.NotNull;

public class Transformer implements Comparable<Transformer> {

    @NotNull
    TransformerType type;
    String name;
    Integer strength;
    Integer intelligence;
    Integer speed;
    Integer endurance;
    Integer rank;
    Integer courage;
    Integer firepower;

    private Integer skill;

    Transformer() {
        setSkill();
    }

    private void setSkill(){
        skill = strength + intelligence + speed + endurance + firepower;
    }

    @Override
    public int compareTo(@NotNull Transformer o) {
        if(name.equals("Optimus Prime") || name.equals("Predaking")){
            return 1;
        } else return skill.compareTo(o.skill);
    }
}
