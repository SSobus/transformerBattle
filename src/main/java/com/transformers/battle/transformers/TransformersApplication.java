package com.transformers.battle.transformers;

import com.transformers.battle.transformers.strategies.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TransformersApplication {

    public static List<BattleStrategy> battleStrategies;

    public static void main(String[] args) {
        SpringApplication.run(TransformersApplication.class, args);

        battleStrategies.add(new SpecialNameBattleStrategy());
        battleStrategies.add(new CourageAndStrengthBattleStrategy());
        battleStrategies.add(new RankBattleStrategy());
        battleStrategies.add(new OverallRatingBattleStrategy());
    }

}
