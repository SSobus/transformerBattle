package com.transformers.battle.transformers;

import com.transformers.battle.transformers.dao.TransformerRepository;
import com.transformers.battle.transformers.model.Transformer;
import com.transformers.battle.transformers.model.TransformerType;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TransformerInitializer implements ApplicationListener<ApplicationReadyEvent> {

    private final TransformerRepository repository;

    public TransformerInitializer(TransformerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        generateAll();
    }

    public void generateAll() {
//        List<Transformer> transformerList = new ArrayList<>();
//
//        repository.save(initializeTransformer("Ironhide", TransformerType.AUTOBOT, 7, 5, 6, 8, 2, 7, 8));
//        repository.save(initializeTransformer("Jolt", TransformerType.AUTOBOT, 5, 3, 4, 4, 4, 3, 5));
//        repository.save(initializeTransformer("Brains", TransformerType.AUTOBOT, 3, 10, 8, 6, 4, 5, 2));
//
//        repository.save(initializeTransformer("Payload", TransformerType.DECEPTICON, 7, 2, 5, 5, 4, 9, 8));
//        repository.save(initializeTransformer("Soundwave", TransformerType.DECEPTICON, 5, 4, 7, 10, 8, 7, 5));
//        repository.save(initializeTransformer("Bonecrusher", TransformerType.DECEPTICON, 10, 3, 8, 3, 6, 8, 7));

        //repository.saveAll(transformerList);
    }

    public Transformer initializeTransformer(String name, TransformerType type, Integer strength, Integer intelligence, Integer speed, Integer endurance, Integer rank, Integer courage, Integer firepower) {
        Transformer transformer = new Transformer();

        transformer.setName(name);
        transformer.setType(type);
        transformer.setStrength(strength);
        transformer.setIntelligence(intelligence);
        transformer.setSpeed(speed);
        transformer.setEndurance(endurance);
        transformer.setRank(rank);
        transformer.setCourage(courage);
        transformer.setFirepower(firepower);

        transformer.setSkill(transformer.determineSkill());

        return transformer;
    }

}
