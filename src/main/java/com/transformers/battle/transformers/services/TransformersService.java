package com.transformers.battle.transformers.services;

import com.transformers.battle.transformers.model.Transformer;

import java.util.List;

public interface TransformersService {

    Integer createTransformers();
    Transformer getTransformers(Integer id);
    Transformer postTransformers(Integer id);
    Boolean deleteTransformers(Integer id);
    List<Transformer> listTransformers();
}
