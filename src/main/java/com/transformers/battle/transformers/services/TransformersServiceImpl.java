package com.transformers.battle.transformers.services;

import com.transformers.battle.transformers.dao.TransformerRepository;
import com.transformers.battle.transformers.model.Transformer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Set;

@Service
public class TransformersServiceImpl implements TransformersService {

    TransformerRepository transformerRepository;

    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    Validator validator = factory.getValidator();

    TransformersServiceImpl(TransformerRepository transformerRepository) {
        this.transformerRepository = transformerRepository;
    }

    @Override
    public Integer createTransformers(Transformer transformer) {
        Set<ConstraintViolation<Transformer>> constraintViolations = validator.validate(transformer);

        if (!constraintViolations.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, constraintViolations.toString());
        }

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
        Set<ConstraintViolation<Transformer>> constraintViolations = validator.validate(transformer);

        if (!constraintViolations.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, constraintViolations.toString());
        }

        if (transformer.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot update blank id");
        }

        try {
            transformerRepository.getOne(transformer.getId());
        } catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Entity not found, Id does not exist");
        }

        Transformer entity = transformerRepository.save(transformer);
        return entity.getId();
    }

    @Override
    public void deleteTransformers(Integer id) {

        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot delete blank id");
        }

        try {
            transformerRepository.getOne(id);
        } catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Entity not found, Id does not exist");
        }

        transformerRepository.deleteById(id);
    }

    @Override
    public List<Transformer> listTransformers() {
        return transformerRepository.findAll();
    }

    @Override
    public List<Transformer> listTransformersByIds(List<Integer> transformerIds) {
        return transformerRepository.findAllById(transformerIds);
    }
}
