package com.transformers.battle.transformers.dao;

import com.transformers.battle.transformers.model.Transformer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransformerRepository extends JpaRepository<Transformer, Long> {


}
