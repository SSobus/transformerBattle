package com.transformers.battle.transformers.services;

import com.transformers.battle.transformers.dao.TransformerRepository;
import com.transformers.battle.transformers.model.Transformer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransformersServiceImpl implements TransformersService {

    TransformerRepository transformerRepository;

    TransformersServiceImpl(TransformerRepository transformerRepository) {
        this.transformerRepository = transformerRepository;
    }

    @Override
    public Integer createTransformers(Transformer transformer) {
        Transformer entity = transformerRepository.save(transformer);
        return entity.getId();
    }

    @Override
    public Transformer getTransformers(Integer id) {
        Transformer entity = transformerRepository.getOne(id);
        return entity;
    }

    @Override
    public Integer postTransformers(Transformer transformer) {
        Transformer entity = transformerRepository.save(transformer);
        return entity.getId();
    }

    @Override
    public void deleteTransformers(Integer id) {
        transformerRepository.deleteById(id);
    }

    @Override
    public List<Transformer> listTransformers() {
        List<Transformer> transformers = transformerRepository.findAll();
        return transformers;
    }
}
