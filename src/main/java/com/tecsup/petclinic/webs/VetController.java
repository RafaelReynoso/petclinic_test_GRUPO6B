package com.tecsup.petclinic.webs;

import com.tecsup.petclinic.domain.VetTO;
import com.tecsup.petclinic.entities.Vet;
import com.tecsup.petclinic.exception.VetNotFoundException;
import com.tecsup.petclinic.mapper.VetMapper;
import com.tecsup.petclinic.services.VetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class VetController {
    private VetService vetService;
    private VetMapper mapper;

    public VetController(VetService vetService, VetMapper mapper) {
        this.vetService = vetService;
        this.mapper = mapper;
    }

    @GetMapping(value = "/vets")
    public ResponseEntity<List<VetTO>> findAllVets(){
        List<Vet> vets = (List<Vet>) vetService.findAll();
        log.info("vets: " + vets);
        vets.forEach(item -> log.info("Vet >>  {} ", item));

        List<VetTO> vetsTo = this.mapper.toVetTOList(vets);
        log.info("vetsTO: " + vetsTo);
        vetsTo.forEach(item -> log.info("vetsTo >>  {} ", item));

        return ResponseEntity.ok(vetsTo);
    }

    @PostMapping(value = "/vets")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<VetTO> create(@RequestBody VetTO vetTO){

        Vet newVet = this.mapper.toVet(vetTO);
        VetTO newVetTO = this.mapper.toVetTO(vetService.create(newVet));

        return ResponseEntity.status(HttpStatus.CREATED).body(newVetTO);

    }

    @PutMapping(value = "/vets/{id}")
    ResponseEntity<VetTO> update(@RequestBody VetTO vetTO, @PathVariable Integer id){

        VetTO updateVetTO = null;

        try{

            Vet updateVet = vetService.findById(id);

            updateVet.setName(vetTO.getFirst_name());
            updateVet.setLastname(vetTO.getLast_name());



            vetService.update(updateVet);

            updateVetTO = this.mapper.toVetTO(updateVet);

        }catch (VetNotFoundException e ){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updateVetTO);

    }
}
