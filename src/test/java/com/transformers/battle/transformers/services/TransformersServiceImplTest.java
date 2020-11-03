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
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static com.transformers.battle.transformers.TransformerGenerator.initializeTransformer;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
        Long result = transformersService.createTransformers(transformer);
        Assert.assertEquals(1, (long) result);
    }

    @Test
    void shouldThrowExceptionWhenSkillGreaterThan10() {
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            Transformer transformer = initializeTransformer("Slug", TransformerType.AUTOBOT, 11, 1, 1, 1, 1, 1, 1);
            transformersService.createTransformers(transformer);
        });

        assertTrue(exception.getMessage().contains("strength"));
    }

    @Test
    void shouldThrowExceptionWhenSkillLessThan1() {
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            Transformer transformer = initializeTransformer("Slug", TransformerType.AUTOBOT, 0, 1, 1, 1, 1, 1, 1);
            transformersService.createTransformers(transformer);
        });

        assertTrue(exception.getMessage().contains("strength"));
    }

    @Test
    void shouldThrowExceptionWhenNameBlank() {
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            Transformer transformer = initializeTransformer("", TransformerType.AUTOBOT, 0, 1, 1, 1, 1, 1, 1);
            transformersService.createTransformers(transformer);
        });

        assertTrue(exception.getMessage().contains("strength"));
    }


    @Test
    void getTransformers() {
        Transformer transformer = initializeTransformer("Barricade", TransformerType.DECEPTICON, 10, 9, 8, 7, 6, 5, 4);
        when(transformerRepository.getOne(any(Integer.class))).thenReturn(transformer);

        Transformer result = transformersService.getTransformers(1);

        Assert.assertNotNull(result);
    }

    @Test
    void postTransformers() {
        Transformer transformer = initializeTransformer("Barricade", TransformerType.DECEPTICON, 10, 9, 8, 7, 6, 5, 4);
        when(transformerRepository.save(any(Transformer.class))).thenReturn(transformer);
        when(transformerRepository.getOne(any(Integer.class))).thenReturn(transformer);

        Long result = transformersService.postTransformers(transformer);

        Assert.assertEquals(1, (long) result);
    }

    @Test
    void shouldThrowExceptionWhenIdNull() {
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            Transformer transformer = initializeTransformer("Barricade", TransformerType.DECEPTICON, 10, 9, 8, 7, 6, 5, 4);
            transformer.setId(null);

            transformersService.postTransformers(transformer);
        });

        assertTrue(exception.getMessage().contains("blank id"));
    }

    @Test
    void shouldThrowExceptionWhenIdDoesNotExist() {
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            Transformer transformer = initializeTransformer("Barricade", TransformerType.DECEPTICON, 10, 9, 8, 7, 6, 5, 4);
            doThrow(EntityNotFoundException.class).when(transformerRepository).getOne(any(Integer.class));

            transformersService.postTransformers(transformer);
        });

        assertTrue(exception.getMessage().contains("does not exist"));
    }

    @Test
    void shouldThrowExceptionWhenValueGreaterThan10() {
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            Transformer transformer = initializeTransformer("Slug", TransformerType.AUTOBOT, 11, 1, 1, 1, 1, 1, 1);
            when(transformerRepository.save(any(Transformer.class))).thenReturn(transformer);
            when(transformerRepository.getOne(any(Integer.class))).thenReturn(transformer);
            transformersService.postTransformers(transformer);
        });

        assertTrue(exception.getMessage().contains("strength"));
    }

    @Test
    void shouldThrowExceptionWhenValueLessThan1() {
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            Transformer transformer = initializeTransformer("Slug", TransformerType.AUTOBOT, 0, 1, 1, 1, 1, 1, 1);
            when(transformerRepository.save(any(Transformer.class))).thenReturn(transformer);
            when(transformerRepository.getOne(any(Integer.class))).thenReturn(transformer);
            transformersService.postTransformers(transformer);
        });

        assertTrue(exception.getMessage().contains("strength"));
    }

    @Test
    void deleteTransformers() {
        Transformer transformer = initializeTransformer("Barricade", TransformerType.DECEPTICON, 10, 9, 8, 7, 6, 5, 4);
        doNothing().when(transformerRepository).deleteById(any(Integer.class));

        transformersService.deleteTransformers(transformer.getId());
    }

    @Test
    void shouldThrowExceptionWhenNullId() {
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            doNothing().when(transformerRepository).deleteById(any(Integer.class));
            transformersService.deleteTransformers(null);
        });

        assertTrue(exception.getMessage().contains("blank id"));
    }

    @Test
    void shouldThrowExceptionWhenIdNotFound() {
        Exception exception = assertThrows(ResponseStatusException.class, () -> {
            doThrow(EntityNotFoundException.class).when(transformerRepository).deleteById(any(Integer.class));
            transformersService.deleteTransformers(null);
        });

        assertTrue(exception.getMessage().contains("blank id"));
    }

    @Test
    void listTransformers() {
        List<Transformer> transformers = new ArrayList<>();
        transformers.add(initializeTransformer("Barricade", TransformerType.DECEPTICON, 10, 9, 8, 7, 6, 5, 4));
        transformers.add(initializeTransformer("Ironhide", TransformerType.AUTOBOT, 1, 2, 3, 4, 5, 6, 7));

        when(transformerRepository.findAll()).thenReturn(transformers);

        List<Transformer> result = transformersService.listTransformers();

        assertEquals(2, result.size());
    }

}