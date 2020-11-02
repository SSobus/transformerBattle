package com.transformers.battle.transformers.strategies;

import com.transformers.battle.transformers.model.BattleOutcome;
import com.transformers.battle.transformers.model.BattleResult;
import com.transformers.battle.transformers.model.Transformer;

public class RankBattleStrategy implements BattleStrategy {
    @Override
    public BattleResult runBattleStrategy(Transformer autobot, Transformer decepticon) {
        if (autobot.getRank() - decepticon.getRank() >= 3) {
            return new BattleResult(autobot, BattleOutcome.AUTOBOT_WIN, "Autobot Rank 3 or greater win");
        } else if (decepticon.getRank() - autobot.getRank() >= 3) {
            return new BattleResult(decepticon, BattleOutcome.DECEPTICON_WIN, "Decepticon Rank 3 or greater win");
        }

        return new BattleResult(null, BattleOutcome.NOT_APPLICABLE, "No Rank Win");
    }
}
