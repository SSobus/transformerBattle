package com.transformers.battle.transformers.strategies;

import com.transformers.battle.transformers.model.BattleOutcome;
import com.transformers.battle.transformers.model.BattleResult;
import com.transformers.battle.transformers.model.Transformer;

public class CourageAndStrengthBattleStrategy implements BattleStrategy {
    @Override
    public BattleResult runBattleStrategy(Transformer autobot, Transformer decepticon) {
        if (autobot.getCourage() - decepticon.getCourage() >= 4 && autobot.getStrength() - decepticon.getStrength() >= 3) {
            return new BattleResult(autobot, BattleOutcome.AUTOBOT_WIN, "Autobot Courage 4 and Strength 3 win");
        } else if (decepticon.getCourage() - autobot.getCourage() >= 4 && decepticon.getStrength() - autobot.getStrength() >= 3) {
            return new BattleResult(autobot, BattleOutcome.DECEPTICON_WIN, "Decepticon Courage 4 and Strength 3 win");
        }

        return new BattleResult(null, BattleOutcome.NOT_APPLICABLE, "No Courage and Strength win");
    }
}
