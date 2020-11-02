package com.transformers.battle.transformers.services;

import com.transformers.battle.transformers.model.Outcome;

import java.util.List;

public interface BattleService {
    Outcome battle(List<Integer> transformers);
}
