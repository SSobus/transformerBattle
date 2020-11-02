package com.transformers.battle.transformers.services;

import com.transformers.battle.transformers.TransformersApplication;
import com.transformers.battle.transformers.model.*;
import com.transformers.battle.transformers.strategies.BattleStrategy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BattleServiceImpl implements BattleService {
    private List<Transformer> autobots;
    private List<Transformer> decepticons;

    @Override
    public Outcome battle(List<Transformer> transformers) {
        List<BattleResult> battleResults;
        autobots = new ArrayList<>();
        decepticons = new ArrayList<>();

        splitTransformerTeams(transformers);

        Collections.sort(autobots);
        Collections.sort(decepticons);

        int battles = 0;
        int autobotWins = 0;
        int decepticonWins = 0;

        int minSize = Math.min(autobots.size(), decepticons.size());

        //battle
        for (int index = 0; index < minSize; index++) {
            //clear strategy results
            battleResults = new ArrayList<>();

            //run strategies
            for (BattleStrategy strategy : TransformersApplication.battleStrategies) {
                battleResults.add(strategy.runBattleStrategy(autobots.get(index), decepticons.get(index)));
            }
            battles++;

            //evaluate strategies
            for (BattleResult battleResult : battleResults) {
                if (battleResult.getOutcome() == BattleOutcome.BOTH_DESTROYED) {
                    break;
                } else if (battleResult.getOutcome() == BattleOutcome.AUTOBOT_WIN) {
                    autobotWins++;
                    break;
                } else if (battleResult.getOutcome() == BattleOutcome.DECEPTICON_WIN) {
                    decepticonWins++;
                    break;
                }
            }
        }

        //evaluate outcome
        Outcome outcome = new Outcome();
        outcome.setBattles(battles);

        if (autobotWins > decepticonWins) {
            outcome.setWinningTeam(TransformerType.AUTOBOT);
        } else if (autobotWins < decepticonWins) {
            outcome.setWinningTeam(TransformerType.DECEPTICON);
        } else {
            outcome.setWinningTeam(null);
        }

        if (autobots.size() > minSize) {
            outcome.setSurvivingMembers(autobots.subList(minSize, autobots.size() - 1));
        } else if (decepticons.size() > minSize) {
            outcome.setSurvivingMembers(decepticons.subList(minSize, decepticons.size() - 1));
        }

        return outcome;
    }

    private void splitTransformerTeams(List<Transformer> transformers) {
        for (Transformer transformer : transformers) {
            if (transformer.getType() == TransformerType.AUTOBOT) {
                autobots.add(transformer);
            } else if (transformer.getType() == TransformerType.DECEPTICON) {
                decepticons.add(transformer);
            }
        }
    }
}
