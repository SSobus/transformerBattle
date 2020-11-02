package com.transformers.battle.transformers.services;

import com.transformers.battle.transformers.dao.TransformerRepository;
import com.transformers.battle.transformers.model.Transformer;
import com.transformers.battle.transformers.model.TransformerType;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class TransformersServiceImplTest {

    @InjectMocks
    private TransformersServiceImpl transformersService;
    @Mock
    private TransformerRepository transformerRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        transformersService = new TransformersServiceImpl(transformerRepository);
    }


    @Test
    void shouldCreateTransformer() {
        Transformer transformer = initializeTransformer("Ironhide", TransformerType.AUTOBOT, 1, 2, 3, 4, 5, 6, 7);
        when(transformerRepository.save(any(Transformer.class))).thenReturn(transformer);
        Integer result = transformersService.createTransformers(transformer);
        Assert.assertEquals(1, (int) result);
    }


    @Test
    void getTransformers() {
    }

    @Test
    void postTransformers() {
    }

    @Test
    void deleteTransformers() {
    }

    @Test
    void listTransformers() {
    }

    private Transformer initializeTransformer(String name, TransformerType type, Integer strength, Integer intelligence, Integer speed, Integer endurance, Integer rank, Integer courage, Integer firepower) {
        Transformer transformer = new Transformer();

        transformer.setId(1);

        transformer.setName(name);
        transformer.setType(type);
        transformer.setStrength(strength);
        transformer.setIntelligence(intelligence);
        transformer.setSpeed(speed);
        transformer.setEndurance(endurance);
        transformer.setRank(rank);
        transformer.setCourage(courage);
        transformer.setFirepower(firepower);

        transformer.determineSkill();

        return transformer;
    }
}