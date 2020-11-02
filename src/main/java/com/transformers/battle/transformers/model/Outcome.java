package com.transformers.battle.transformers.model;

import java.util.List;

public class Outcome {
    Integer battles;
    TransformerType winningTeam;
    List<Transformer> survivingMembers;

    public Integer getBattles() {
        return battles;
    }

    public void setBattles(Integer battles) {
        this.battles = battles;
    }

    public TransformerType getWinningTeam() {
        return winningTeam;
    }

    public void setWinningTeam(TransformerType winningTeam) {
        this.winningTeam = winningTeam;
    }

    public List<Transformer> getSurvivingMembers() {
        return survivingMembers;
    }

    public void setSurvivingMembers(List<Transformer> survivingMembers) {
        this.survivingMembers = survivingMembers;
    }
}
