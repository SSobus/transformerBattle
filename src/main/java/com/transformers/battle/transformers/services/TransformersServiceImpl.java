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
    public Long createTransformers(Transformer transformer) {
        Set<ConstraintViolation<Transformer>> constraintViolations = validator.validate(transformer);

        if (!constraintViolations.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, constraintViolations.toString());
        }

        Transformer entity = transformerRepository.save(transformer);
        return entity.getId();
    }

    @Override
    public Transformer getTransformers(Long id) {
        Transformer entity = transformerRepository.getOne(id);
        return entity;
    }

    @Override
    public Long putTransformers(Transformer transformer) {
        Set<ConstraintViolation<Transformer>> constraintViolations = validator.validate(transformer);

        if (!constraintViolations.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, constraintViolations.toString());
        }

        try {
            Transformer existing = transformerRepository.getOne(transformer.getId());

            existing.setName(transformer.getName());
            existing.setType(transformer.getType());
            existing.setStrength(transformer.getStrength());
            existing.setIntelligence(transformer.getIntelligence());
            existing.setSpeed(transformer.getSpeed());
            existing.setEndurance(transformer.getEndurance());
            existing.setRank(transformer.getRank());
            existing.setCourage(transformer.getCourage());
            existing.setFirepower(transformer.getFirepower());

            transformerRepository.save(existing);
            return existing.getId();

        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Entity not found, Id does not exist");
        }
    }

    @Override
    public void deleteTransformers(Long id) {

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
    public List<Transformer> listTransformersByIds(List<Long> transformerIds) {
        return transformerRepository.findAllById(transformerIds);
    }
}
