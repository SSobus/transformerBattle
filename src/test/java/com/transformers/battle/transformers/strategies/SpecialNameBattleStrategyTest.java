package com.transformers.battle.transformers.strategies;

import com.transformers.battle.transformers.model.BattleOutcome;
import com.transformers.battle.transformers.model.BattleResult;
import com.transformers.battle.transformers.model.Transformer;
import com.transformers.battle.transformers.model.TransformerType;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static com.transformers.battle.transformers.TransformerGenerator.initializeTransformer;

class SpecialNameBattleStrategyTest {

    @Test
    void shouldWinByNameAutobot() {
        Transformer autobot = initializeTransformer("Optimus Prime", TransformerType.AUTOBOT, 1, 2, 3, 4, 5, 6, 7);
        Transformer decepticon = initializeTransformer("Loser", TransformerType.DECEPTICON, 1, 1, 1, 1, 1, 1, 1);

        SpecialNameBattleStrategy strategy = new SpecialNameBattleStrategy();
        BattleResult result = strategy.runBattleStrategy(autobot, decepticon);

        Assert.assertEquals(BattleOutcome.AUTOBOT_WIN, result.getOutcome());
    }

    @Test
    void shouldWinByNameDecepticon() {
        Transformer autobot = initializeTransformer("Loser", TransformerType.AUTOBOT, 1, 2, 3, 4, 5, 6, 7);
        Transformer decepticon = initializeTransformer("Predaking", TransformerType.DECEPTICON, 1, 1, 1, 1, 1, 1, 1);

        SpecialNameBattleStrategy strategy = new SpecialNameBattleStrategy();
        BattleResult result = strategy.runBattleStrategy(autobot, decepticon);

        Assert.assertEquals(BattleOutcome.DECEPTICON_WIN, result.getOutcome());
    }

    @Test
    void shouldNameBothBeDestroyed() {
        Transformer autobot = initializeTransformer("Optimus Prime", TransformerType.AUTOBOT, 1, 2, 3, 4, 5, 6, 7);
        Transformer decepticon = initializeTransformer("Predaking", TransformerType.DECEPTICON, 1, 1, 1, 1, 1, 1, 1);

        SpecialNameBattleStrategy strategy = new SpecialNameBattleStrategy();
        BattleResult result = strategy.runBattleStrategy(autobot, decepticon);

        Assert.assertEquals(BattleOutcome.BOTH_DESTROYED, result.getOutcome());
    }

    @Test
    void shouldBeNameNotApplicable() {
        Transformer autobot = initializeTransformer("NoName", TransformerType.AUTOBOT, 1, 2, 3, 4, 5, 6, 7);
        Transformer decepticon = initializeTransformer("FakeName", TransformerType.DECEPTICON, 1, 1, 1, 1, 1, 1, 1);

        SpecialNameBattleStrategy strategy = new SpecialNameBattleStrategy();
        BattleResult result = strategy.runBattleStrategy(autobot, decepticon);

        Assert.assertEquals(BattleOutcome.NOT_APPLICABLE, result.getOutcome());
    }

}