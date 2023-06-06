package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.tecsup.petclinic.entities.Vet;

public class VetServiceTest {
	
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
		String FIND_LASTNAME = "Carter";
        int SIZE_EXPECTED = 1;

        List<Vet> vets = this.VetService.findByLastname(FIND_LASTNAME);

        assertEquals(SIZE_EXPECTED, vets.size());
	}

	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

}
