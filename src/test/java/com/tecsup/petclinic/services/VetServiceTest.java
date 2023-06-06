package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tecsup.petclinic.entities.Vet;

class VetServiceTest {
	
	@Autowired
    private VetService VetService;

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		
		
        String VET_NAME = "Helen";
        String VET_LASTNAME = "Leary";
        
        String UP_VET_NAME = "Jorge";
        String UP_VET_LASTNAME = "Trinidad";

        Vet vet = new Vet(VET_NAME, VET_LASTNAME);

        // ------------ Create ---------------

        log.info(">" + vet);
        Vet vetCreated = this.VetService.create(vet);
        log.info(">>" + vetCreated);

        // ------------ Update ---------------

        // Prepare data for update
        vetCreated.setName(UP_VET_NAME);
        vetCreated.setLastname(UP_VET_LASTNAME);
        
        // Execute update
        Vet upgradeVet = this.VetService.update(vetCreated);
        log.info(">>>>" + upgradeVet);

        //            EXPECTED        ACTUAL
        assertEquals(UP_VET_NAME, upgradeVet.getName());
        assertEquals(UP_VET_LASTNAME, upgradeVet.getLastname());
		
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByName() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByLastname() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

}
