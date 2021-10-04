package com.github.conorburke.melcore.owners.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.conorburke.melcore.owners.events.source.SimpleSourceBean;
import com.github.conorburke.melcore.owners.model.Owner;
import com.github.conorburke.melcore.owners.repository.OwnerRepository;

@Service
public class OwnerService {
	
    @Autowired
    private OwnerRepository repository;

    @Autowired
    SimpleSourceBean simpleSourceBean;

    public List<Owner> getOwners() {
        return repository.findAll();
    }

    public Owner findById(String ownerId) {
    	Optional<Owner> opt = repository.findById(ownerId);
        return (opt.isPresent()) ? opt.get() : null;
    }

    public Owner create(Owner owner){
    	owner.setId( UUID.randomUUID().toString());
        owner = repository.save(owner);
        simpleSourceBean.publishOwnerChange("SAVE", owner.getId());
        return owner;

    }

    public void update(Owner owner){
    	repository.save(owner);
    }

    public void delete(Owner owner){
    	repository.deleteById(owner.getId());
    }
}