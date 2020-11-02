package com.transformers.battle.transformers.services;

import com.transformers.battle.transformers.model.Transformer;

import java.util.List;

public interface TransformersService {

    Long createTransformers(Transformer transformer);

    Transformer getTransformers(Integer id);

    Long postTransformers(Transformer transformer);

    void deleteTransformers(Long id);

    List<Transformer> listTransformers();

    List<Transformer> listTransformersByIds(List<Integer> transformerIds);
}
