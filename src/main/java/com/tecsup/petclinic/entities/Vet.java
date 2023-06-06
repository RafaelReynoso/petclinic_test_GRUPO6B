package com.tecsup.petclinic.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "vets")
@Data
public class Vet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String name;
    @Column(name = "last_name")
    private String lastname;

    public Vet() {
    }
    public Vet(Integer id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }
    public Vet(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }
}
