package com.transformers.battle.transformers.model;

import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
public class Transformer implements Serializable, Comparable<Transformer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @NotEmpty
    String name;

    @NotNull
    TransformerType type;

    @NotNull
    @Min(1)
    @Max(10)
    Integer strength;

    @NotNull
    @Min(1)
    @Max(10)
    Integer intelligence;

    @NotNull
    @Min(1)
    @Max(10)
    Integer endurance;

    @NotNull
    @Min(1)
    @Max(10)
    Integer speed;

    @NotNull
    @Min(1)
    @Max(10)
    Integer rank;

    @NotNull
    @Min(1)
    @Max(10)
    Integer courage;

    @NotNull
    @Min(1)
    @Max(10)
    Integer firepower;

    @Transient
    private Integer skill;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public void setSkill(Integer skill) {
        this.skill = skill;
    }

    public Integer determineSkill() {
        return (strength + intelligence + speed + endurance + firepower);
    }

    @Override
    public int compareTo(@NotNull Transformer o) {
        return rank.compareTo(o.rank);
    }
}
