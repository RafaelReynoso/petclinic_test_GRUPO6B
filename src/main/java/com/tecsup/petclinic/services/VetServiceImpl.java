package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.PetNotFoundException;
import com.tecsup.petclinic.exception.VetNotFoundException;
import com.tecsup.petclinic.repositories.VetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VetServiceImpl implements VetService{

    VetRepository vetRepository;

    public VetServiceImpl(VetRepository vetRepository) {
        this. vetRepository = vetRepository;
    }

    /**
     *
     * @param vet
     * @return
     */
    @Override
    public Vet create(Vet vet) {
        return null;
    }

    /**
     *
     * @param vet
     * @return
     */
    @Override
    public Vet update(Vet vet) {
        return null;
    }

    /**
     *
     * @param id
     * @throws VetNotFoundException
     */
    @Override
    public void delete(Integer id) throws VetNotFoundException {

    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Vet findById(Integer id) throws VetNotFoundException {
        return null;
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public List<Vet> findByName(String name) {
        return null;
    }

    /**
     *
     * @param lastname
     * @return
     */
    @Override
    public List<Vet> findByLastname(String lastname) {
        return null;
    }

    @Override
    public List<Vet> findAll() {
        return null;
    }
}
