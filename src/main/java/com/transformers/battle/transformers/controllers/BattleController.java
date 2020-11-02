package com.transformers.battle.transformers.controllers;

import com.transformers.battle.transformers.model.Outcome;
import com.transformers.battle.transformers.model.Transformer;
import com.transformers.battle.transformers.services.BattleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BattleController {

    BattleService battleService;

    BattleController(BattleService battleService) {
        this.battleService = battleService;
    }

    @PostMapping("/battle")
    public ResponseEntity<Outcome> battle(@RequestBody List<Transformer> transformers) {
        Outcome outcome = battleService.battle(transformers);
        return ResponseEntity.ok(outcome);
    }
}
