package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.animals;
import org.example.repository.AnimalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Transactional
    public animals updateAnimal(UUID animal_id, String animal_name, String size) {
        Optional<animals> animalOpt = animalRepository.findById(animal_id);

        if (animalOpt.isEmpty()) {
            throw new RuntimeException("Animal not found with id: " + animal_id);
        }

        animals animal = animalOpt.get();
        animal.setAnimal_name(animal_name);
        animal.setSize(size);

        return animalRepository.save(animal);
    }

    @Transactional
    public animals addNewAnimal(String animal_name, String size) {
        animals animal = new animals();
        animal.setAnimal_id(UUID.randomUUID());
        animal.setAnimal_name(animal_name);
        animal.setSize(size);

        return animalRepository.save(animal);
    }

    @Transactional
    public void delAnimalById(UUID animal_id) {
        animalRepository.deleteById(animal_id);
    }
}