package com.transformers.battle.transformers.strategies;

import com.transformers.battle.transformers.model.BattleOutcome;
import com.transformers.battle.transformers.model.BattleResult;
import com.transformers.battle.transformers.model.Transformer;

public class OverallRatingBattleStrategy implements BattleStrategy {
    @Override
    public BattleResult runBattleStrategy(Transformer autobot, Transformer decepticon) {
        autobot.setSkill(autobot.determineSkill());
        decepticon.setSkill(decepticon.determineSkill());

        if (autobot.getSkill().equals(decepticon.getSkill())) {
            return new BattleResult(null, BattleOutcome.BOTH_DESTROYED, "Equal Rating, No winner");
        }

        if (autobot.getSkill() > decepticon.getSkill()) {
            return new BattleResult(autobot, BattleOutcome.AUTOBOT_WIN, "Autobot Skill Win");
        } else if (autobot.getSkill() < decepticon.getSkill()) {
            return new BattleResult(decepticon, BattleOutcome.DECEPTICON_WIN, "Decepticon Skill Win");
        }

        return new BattleResult(decepticon, BattleOutcome.NOT_APPLICABLE, "Not Applicable");
    }
}
