package com.transformers.battle.transformers.services;

import com.transformers.battle.transformers.model.Outcome;
import com.transformers.battle.transformers.model.Transformer;

import java.util.List;

public interface BattleService {

    Outcome battle(List<Transformer> transformers);
}
