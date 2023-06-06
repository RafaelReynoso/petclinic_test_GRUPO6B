package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;

import java.util.List;

public class VetServideImpl implements VetService{
    @Override
    public Vet create(Vet vet) {
        return null;
    }

    @Override
    public Vet update(Vet vet) {
        return null;
    }

    @Override
    public void delete(Integer id) throws VetNotFoundException {

    }

    @Override
    public Vet findById(Integer id) throws VetNotFoundException {
        return null;
    }

    @Override
    public List<Vet> findByName(String name) {
        return null;
    }

    @Override
    public List<Vet> findByLastname(String lastname) {
        return null;
    }

    @Override
    public List<Vet> findAll() {
        return null;
    }
}
