package com.transformers.battle.transformers.strategies;

import com.transformers.battle.transformers.model.BattleOutcome;
import com.transformers.battle.transformers.model.BattleResult;
import com.transformers.battle.transformers.model.Transformer;
import com.transformers.battle.transformers.model.TransformerType;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static com.transformers.battle.transformers.TransformerGenerator.initializeTransformer;

class CourageAndStrengthBattleStrategyTest {
    @Test
    void shouldWinByCourageAndRankAutobot() {
        Transformer autobot = initializeTransformer("Optimus Prime", TransformerType.AUTOBOT, 4, 1, 1, 1, 1, 5, 1);
        Transformer decepticon = initializeTransformer("Loser", TransformerType.DECEPTICON, 1, 1, 1, 1, 1, 1, 1);

        CourageAndStrengthBattleStrategy strategy = new CourageAndStrengthBattleStrategy();
        BattleResult result = strategy.runBattleStrategy(autobot, decepticon);

        Assert.assertEquals(BattleOutcome.AUTOBOT_WIN, result.getOutcome());
    }

    @Test
    void shouldWinByCourageAndRankDecepticon() {
        Transformer autobot = initializeTransformer("Loser", TransformerType.AUTOBOT, 1, 1, 1, 1, 1, 1, 1);
        Transformer decepticon = initializeTransformer("Predaking", TransformerType.DECEPTICON, 4, 1, 1, 1, 1, 5, 1);

        CourageAndStrengthBattleStrategy strategy = new CourageAndStrengthBattleStrategy();
        BattleResult result = strategy.runBattleStrategy(autobot, decepticon);

        Assert.assertEquals(BattleOutcome.DECEPTICON_WIN, result.getOutcome());
    }


    @Test
    void shouldBeCourageAndRankNotApplicable() {
        Transformer autobot = initializeTransformer("NoName", TransformerType.AUTOBOT, 1, 1, 1, 1, 1, 1, 1);
        Transformer decepticon = initializeTransformer("FakeName", TransformerType.DECEPTICON, 1, 1, 1, 1, 1, 1, 1);

        CourageAndStrengthBattleStrategy strategy = new CourageAndStrengthBattleStrategy();
        BattleResult result = strategy.runBattleStrategy(autobot, decepticon);

        Assert.assertEquals(BattleOutcome.NOT_APPLICABLE, result.getOutcome());
    }


}