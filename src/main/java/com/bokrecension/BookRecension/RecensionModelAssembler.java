/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bokrecension.BookRecension;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

/**
 *
 * @author dhambraeus
 */
@Component
public class RecensionModelAssembler implements RepresentationModelAssembler<Recension, EntityModel<Recension>> {
  @Override
  public EntityModel<Recension> toModel(Recension recension) {

    return EntityModel.of(recension, //
        linkTo(methodOn(RecensionController.class).one(recension.getId())).withSelfRel(),
        linkTo(methodOn(RecensionController.class).all()).withRel("employees"));
  }
}
