package org.example;

import org.example.entity.animals;
import org.example.service.AnimalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private AnimalService animalService;

    public Runner(AnimalService animalService) {
        this.animalService = animalService;
    }

    @Override
    public void run(String[] args) {
        // Добавление нового животного
        animals newAnimal = animalService.addNewAnimal("Лев", "200");
        System.out.println("Добавлено новое животное с ID: " + newAnimal.getAnimal_id());

        // Обновление животного
//        animals updatedAnimal = animalService.updateAnimal(newAnimal.getAnimal_id(), "Тигр", "250");
//        System.out.println("Обновлено животное: " + updatedAnimal.getAnimal_name());

        // Удаление животного
//        animalService.delAnimalById(newAnimal.getAnimal_id());
//        System.out.println("Животное удалено");
    }
}