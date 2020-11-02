package com.transformers.battle.transformers.services;

import com.transformers.battle.transformers.model.Transformer;

import java.util.List;

public interface TransformersService {

    Integer createTransformers(Transformer transformer);

    Transformer getTransformers(Integer id);

    Integer postTransformers(Transformer transformer);

    void deleteTransformers(Integer id);

    List<Transformer> listTransformers();

    List<Transformer> listTransformersByIds(List<Integer> transformerIds);
}
