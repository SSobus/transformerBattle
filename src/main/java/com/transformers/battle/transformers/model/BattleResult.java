package com.transformers.battle.transformers.model;

public class BattleResult {

    Transformer winner;
    BattleOutcome outcome;
    String message;

    public BattleResult() {
    }

    public BattleResult(Transformer winner, BattleOutcome outcome, String message) {
        this.winner = winner;
        this.outcome = outcome;
        this.message = message;
    }

    public Transformer getWinner() {
        return winner;
    }

    public void setWinner(Transformer winner) {
        this.winner = winner;
    }

    public BattleOutcome getOutcome() {
        return outcome;
    }

    public void setOutcome(BattleOutcome outcome) {
        this.outcome = outcome;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
