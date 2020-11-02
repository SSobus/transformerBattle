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
        this.transformersService = transformersService;
    }

    @GetMapping("/transformers/{id}")
    public ResponseEntity<Transformer> getTransformer(@PathVariable Integer id){
        Transformer transformer = transformersService.getTransformers(id);
        return ResponseEntity.ok(transformer);
    }

    @PostMapping("/transformers")
    public ResponseEntity<Integer> createTransformer(@RequestBody Transformer transformer) {
        Integer result = transformersService.createTransformers(transformer);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/transformers/{id}")
    public ResponseEntity<Integer> updateTransformer(@PathVariable Integer id, @RequestBody Transformer transformer) {
        Integer result = transformersService.postTransformers(transformer);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/transformers/{id}")
    public ResponseEntity<String> deleteTransformer(@PathVariable Integer id) {
        transformersService.deleteTransformers(id);
        return ResponseEntity.ok("Success");
    }

    @GetMapping("/transformers")
    public ResponseEntity<List<Transformer>> getTransformersList(){
        List<Transformer> transformers = transformersService.listTransformers();
        return ResponseEntity.ok(transformers);
    }
}
