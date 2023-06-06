package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.PetNotFoundException;
import com.tecsup.petclinic.exception.VetNotFoundException;

class VetServiceTest {
	
	@Autowired
    private VetService VetService;

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdate() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

}
