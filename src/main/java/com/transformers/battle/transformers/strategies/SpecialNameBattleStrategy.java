package com.transformers.battle.transformers.strategies;

import com.transformers.battle.transformers.model.BattleOutcome;
import com.transformers.battle.transformers.model.BattleResult;
import com.transformers.battle.transformers.model.Transformer;

public class SpecialNameBattleStrategy implements BattleStrategy {
    @Override
    public BattleResult runBattleStrategy(Transformer autobot, Transformer decepticon) {
        if (autobot.getName().equals("Optimus Prime") && decepticon.getName().equals("Predaking")) {
            return new BattleResult(null, BattleOutcome.BOTH_DESTROYED, "Optimus Prime vs Predaking, all destroyed");
        } else if (autobot.getName().equals("Optimus Prime")) {
            return new BattleResult(autobot, BattleOutcome.AUTOBOT_WIN, "Optimus Prime Auto Win");
        } else if (decepticon.getName().equals("Predaking")) {
            return new BattleResult(decepticon, BattleOutcome.DECEPTICON_WIN, "Predaking Auto Win");
        }

        return new BattleResult(null, BattleOutcome.NOT_APPLICABLE, "Not Applicable");
    }
}
