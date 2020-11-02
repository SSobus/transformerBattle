package com.transformers.battle.transformers.model;


import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
public class Transformer implements Comparable<Transformer> {

    @NotNull
    String name;

    @NotNull
    TransformerType type;
    @NotNull
    Integer strength;
    @NotNull
    Integer intelligence;
    @NotNull
    Integer endurance;
    Integer speed;
    @NotNull
    Integer rank;
    @NotNull
    Integer courage;
    @NotNull
    Integer firepower;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Transient
    private Integer skill;

    public Transformer() {
    }

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TransformerType getType() {
        return type;
    }

    public void setType(TransformerType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getEndurance() {
        return endurance;
    }

    public void setEndurance(Integer endurance) {
        this.endurance = endurance;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getCourage() {
        return courage;
    }

    public void setCourage(Integer courage) {
        this.courage = courage;
    }

    public Integer getFirepower() {
        return firepower;
    }

    public void setFirepower(Integer firepower) {
        this.firepower = firepower;
    }

    public Integer getSkill() {
        return skill;
    }

    public Integer determineSkill() {
        return (strength + intelligence + speed + endurance + firepower);
    }

    @Override
    public int compareTo(@NotNull Transformer o) {
        if (name.equals("Optimus Prime") || name.equals("Predaking")) {
            return 1;
        } else return skill.compareTo(o.skill);
    }
}
