package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;


import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.PetNotFoundException;
import com.tecsup.petclinic.exception.VetNotFoundException;
import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.tecsup.petclinic.entities.Vet;


import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.PetNotFoundException;
import com.tecsup.petclinic.exception.VetNotFoundException;

import com.tecsup.petclinic.entities.Vet;

class VetServiceTest {

@SpringBootTest
@Slf4j
public class VetServiceTest {
	
	@Autowired
    private VetService VetService;

	@Test
	void testCreate() {
		String VET_NAME = "Rocio";
		String VET_LASTNAME = "Duarte";

		Vet vet = new Vet(VET_NAME, VET_LASTNAME);

		Vet vetCreated = this.VetService.create(vet);

		log.info("VET CREATED :" + vetCreated.toString());

		assertNotNull(vetCreated.getId());
		assertEquals(VET_NAME, vetCreated.getName());
		assertEquals(VET_LASTNAME,vetCreated.getLastname());
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
	public void testDeleteVet() {
		  String VET_NAME = "James";
		  String VET_LASTNAME = "Carter";

	        // ------------ Create ---------------

	        Vet vet = new Vet(VET_NAME, VET_LASTNAME);
	        vet = this.VetService.create(vet);
	        log.info("" + vet);

	        // ------------ Delete ---------------

	        try {
	            this.VetService.delete(vet.getId());
	        } catch (VetNotFoundException e) {
	            fail(e.getMessage());
	        }

	        // ------------ Validation ---------------

	        try {
	            this.VetService.findById(vet.getId());
	            assertTrue(false);
	        } catch (VetNotFoundException e) {
	            assertTrue(true);
	        }
	        

	@Test
	void testFindById() {
		Integer ID = 1;
		String VET_NAME = "James";
		Vet vet = null;

		try {
			vet = this.VetService.findById(ID);
		} catch (VetNotFoundException e) {
			fail(e.getMessage());
		}

		log.info(vet.toString());
		assertEquals(VET_NAME, vet.getName());
	}

	@Test
	public void testFindByName() {
		 String FIND_NAME = "Leo";
	        int SIZE_EXPECTED = 1;

	        List<Vet> vets = this.VetService.findByName(FIND_NAME);

	        assertEquals(SIZE_EXPECTED, vets.size());
	    }


	@Test
	void testFindByLastname() {
		String FIND_LASTNAME = "Carter";
        int SIZE_EXPECTED = 1;

        List<Vet> vets = this.VetService.findByLastname(FIND_LASTNAME);

        assertEquals(SIZE_EXPECTED, vets.size());
	}
	
	
	}



}
