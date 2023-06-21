/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bokrecension.BookRecension;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author dhambraeus
 */
@RestController
class RecensionController {

  private final RecensionRepository repository;
  private final RecensionModelAssembler assembler;


  RecensionController(RecensionRepository repository, RecensionModelAssembler assembler) {
    this.repository = repository;
    this.assembler = assembler;
  }
  
  @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
  @GetMapping("/hello")
  public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
    return String.format("Hello %s!", name);
  }

  @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
  @GetMapping("/reviews")
  CollectionModel<EntityModel<Recension>> all() {
      
    List<EntityModel<Recension>> recensioner = repository.findAll().stream()
      .map(assembler::toModel).collect(Collectors.toList());
    
    return CollectionModel.of(recensioner, linkTo(methodOn(RecensionController.class).all()).withSelfRel());
  }

  @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
  @PostMapping("/reviews")
  ResponseEntity<?> newRecension(@RequestBody Recension newRecension) {
    EntityModel<Recension> entityModel = assembler.toModel(repository.save(newRecension));
    
    return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(entityModel);
  }

  @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
  @GetMapping("/reviews/{id}")
  EntityModel<Recension> one(@PathVariable Long id) {
    
    Recension recension = repository.findById(id)
      .orElseThrow(() -> new RecensionNotFoundException(id));
    
    return assembler.toModel(recension);
  }
  
  @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
  @DeleteMapping("/reviews/{id}")
  ResponseEntity<?> deleteRecension(@PathVariable Long id) {
    repository.deleteById(id);
    
    return ResponseEntity.noContent().build();
  }
}

