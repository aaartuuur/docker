package org.example.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "animals")
public class animals {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(nullable = false, unique = true, name = "animal_id")
    private UUID animal_id;

    @Column(nullable = true, name = "animal_name")
    private String animal_name;

    @Column(nullable = true, name = "size")
    private String size;

    // Геттеры и сеттеры
    public UUID getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(UUID animal_id) {
        this.animal_id = animal_id;
    }

    public String getAnimal_name() {
        return animal_name;
    }

    public void setAnimal_name(String animal_name) {
        this.animal_name = animal_name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}