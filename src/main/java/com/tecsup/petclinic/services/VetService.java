package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;

import java.util.List;

public interface VetService {

    /**
     *
     * @param vet
     * @return
     */
    Vet create(Vet vet);

    /**
     *
     * @param vet
     * @return
     */
    Vet update(Vet vet);

    /**
     *
     * @param id
     * @throws
     */
    void delete(Integer id) throws VetNotFoundException;

    /**
     *
     * @param id
     * @return
     */
    Vet findById(Integer id) throws VetNotFoundException;

    /**
     *
     * @param name
     * @return
     */
    List<Vet> findByName(String name);

    /**
     *
     * @param lastname
     * @return
     */
    List<Vet> findByLastname(String lastname);

    /**
     *
     * @return
     */
    List<Vet> findAll();
}
