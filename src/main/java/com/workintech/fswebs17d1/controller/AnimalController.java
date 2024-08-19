package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnimalController {
    Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping("/workintech/animal")
    public List<Animal> getAnimals(){
        return animals.values().stream().toList();
    }

    @GetMapping("/workintech/animal/{id}")
    public Animal getAnimalsId(@PathVariable int id){
        return animals.values().stream().filter(l->l.getId() == id).findFirst().get();
    }

    @PostMapping("/workintech/animal")
    public Animal saveAnimals(@RequestBody Animal animal){
        return animals.put(animal.getId(), animal);
    }

    @PutMapping("/workintech/animal/{id}")
    public Animal putAnimal(@PathVariable int id, @RequestBody Animal animal) {
        animals.put(id, new Animal(1, "cat"));
        return animals.get(id);
    }

    @DeleteMapping("/workintech/animal/{id}")
    public Animal deleteAnimal(@PathVariable int id) {
        Animal animal = animals.get(id);
        animals.remove(animal);
        return animal;
    }

}


