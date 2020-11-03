package com.transformers.battle.transformers.strategies;

import com.transformers.battle.transformers.model.BattleOutcome;
import com.transformers.battle.transformers.model.BattleResult;
import com.transformers.battle.transformers.model.Transformer;
import com.transformers.battle.transformers.model.TransformerType;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static com.transformers.battle.transformers.TransformerGenerator.initializeTransformer;

class OverallRatingBattleStrategyTest {

    @Test
    void shouldWinBySkillAutobot() {
        Transformer autobot = initializeTransformer("Optimus Prime", TransformerType.AUTOBOT, 1, 1, 1, 1, 1, 1, 2);
        Transformer decepticon = initializeTransformer("Loser", TransformerType.DECEPTICON, 1, 1, 1, 1, 1, 1, 1);

        OverallRatingBattleStrategy strategy = new OverallRatingBattleStrategy();
        BattleResult result = strategy.runBattleStrategy(autobot, decepticon);

        Assert.assertEquals(BattleOutcome.AUTOBOT_WIN, result.getOutcome());
    }

    @Test
    void shouldWinBySkillDecepticon() {
        Transformer autobot = initializeTransformer("Loser", TransformerType.AUTOBOT, 1, 1, 1, 1, 1, 1, 1);
        Transformer decepticon = initializeTransformer("Predaking", TransformerType.DECEPTICON, 1, 1, 1, 1, 1, 1, 2);

        OverallRatingBattleStrategy strategy = new OverallRatingBattleStrategy();
        BattleResult result = strategy.runBattleStrategy(autobot, decepticon);

        Assert.assertEquals(BattleOutcome.DECEPTICON_WIN, result.getOutcome());
    }

    @Test
    void shouldSkillBothBeDestroyed() {
        Transformer autobot = initializeTransformer("Optimus Prime", TransformerType.AUTOBOT, 1, 1, 1, 1, 1, 1, 1);
        Transformer decepticon = initializeTransformer("Predaking", TransformerType.DECEPTICON, 1, 1, 1, 1, 1, 1, 1);

        OverallRatingBattleStrategy strategy = new OverallRatingBattleStrategy();
        BattleResult result = strategy.runBattleStrategy(autobot, decepticon);

        Assert.assertEquals(BattleOutcome.BOTH_DESTROYED, result.getOutcome());
    }

}