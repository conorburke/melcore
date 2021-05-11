package com.github.conorburke.melcore.owners.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.conorburke.melcore.owners.model.Owner;
import com.github.conorburke.melcore.owners.service.OwnerService;

@RestController
@RequestMapping(value="v1/owners")
public class OwnerController {
    @Autowired
    private OwnerService service;


    @RequestMapping(value="/{ownerId}",method = RequestMethod.GET)
    public ResponseEntity<Owner> getOwner( @PathVariable("ownerId") String ownerId) {
        return ResponseEntity.ok(service.findById(ownerId));
    }

    @RequestMapping(value="/{ownerId}",method = RequestMethod.PUT)
    public void updateOwner( @PathVariable("ownerId") String id, @RequestBody Owner owner) {
        service.update(owner);
    }

    @PostMapping
    public ResponseEntity<Owner> saveOwner(@RequestBody Owner owner) {
    	return ResponseEntity.ok(service.create(owner));
    }

    @RequestMapping(value="/{ownerId}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOwner( @PathVariable("id") String id,  @RequestBody Owner owner) {
        service.delete(owner);
    }

}