package com.github.conorburke.melcore.owners.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.conorburke.melcore.owners.model.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner,String>  {
    public Optional<Owner> findById(String ownerId);
}