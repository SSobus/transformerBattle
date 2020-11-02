package com.transformers.battle.transformers.strategies;

import com.transformers.battle.transformers.model.BattleResult;
import com.transformers.battle.transformers.model.Transformer;

public interface BattleStrategy {
    BattleResult runBattleStrategy(Transformer autobot, Transformer decepticon);
}
