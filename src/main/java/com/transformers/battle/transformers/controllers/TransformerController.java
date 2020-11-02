package com.transformers.battle.transformers.controllers;

import com.transformers.battle.transformers.model.Transformer;
import com.transformers.battle.transformers.services.TransformersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransformerController {

    TransformersService transformersService;

    TransformerController(TransformersService transformersService){
    }

    @GetMapping("/transformers/{id}")
    public ResponseEntity<Transformer> getTransformer(@PathVariable Integer id){
        Transformer transformer = transformersService.getTransformers(id);

        return ResponseEntity.ok(transformer);
    }

    @PostMapping("/transformers")
    public void createTransformer(){

    }

    @PutMapping("/transformers/{id}")
    public void updateTransformer(@PathVariable Integer id){

    }

    @DeleteMapping("/transformers/{id}")
    public void deleteTransformer(@PathVariable Integer id){

    }

    @GetMapping("/transformers")
    public ResponseEntity<List<Transformer>> getTransformersList(){
        List<Transformer> transformers = transformersService.listTransformers();

        return ResponseEntity.ok(transformers);
    }
}
