package com.tecsup.petclinic.repositories;

import com.tecsup.petclinic.entities.Vet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VetRepository extends CrudRepository<Vet,Integer> {
    List<Vet> findByLastname(String lastname);
    List<Vet> findByName(String name);
}
