package org.cnu.realcoding.controller;

import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.service.DogManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogController {

    @Autowired
    private DogManagementService dogManagementService;

    @PostMapping("/dogs")
    public void createDogs(@RequestBody Dog dog){
        dogManagementService.insertDog(dog);
    }

    @GetMapping("/dogs")
    public List<Dog> getAllDogs() {
        return dogManagementService.getAllDogs();
    }

    // localhost:8005/dogs/ian
    @GetMapping("/dogs/{name}")
    public Dog getDogByName(@PathVariable String name){
        return dogManagementService.getDogByName(name);
    }

}
