package org.cnu.realcoding.controller;

import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.service.DogManagementService;
import org.cnu.realcoding.vo.PatchDog;
import org.cnu.realcoding.vo.PatchDogKind;
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
    @GetMapping("/dogs/name/{name}")
    public List<Dog> getDogByName(@PathVariable String name){
        return dogManagementService.getDogByName(name);
    }

    @GetMapping("/dogs/phone/{ownerPhoneNumber}")
    public List<Dog> getDogByownerPhoneNumber(@PathVariable String ownerPhoneNumber){
        return dogManagementService.getDogByOwnerPhoneNumber(ownerPhoneNumber);
    }
    @GetMapping("/dogs/ownerName/{ownerName}")
    public List<Dog> getDogByownerName(@PathVariable String ownerName){
        return dogManagementService.getDogByOwnerName(ownerName);
    }

    @GetMapping("/dogs/uniqueKey/{name}/{ownerPhoneNumber}/{ownerName}")
    public Dog getDogByUniqueKey(@PathVariable String name, @PathVariable String ownerPhoneNumber, @PathVariable String ownerName){
        return dogManagementService.getDogByUniqueKey(name,ownerName,ownerPhoneNumber);
    }

    @PutMapping("/dogs/ModifyDog/{name}/{ownerPhoneNumber}/{ownerName}")
    public void ModifyDog(@PathVariable String name, @PathVariable String ownerPhoneNumber, @PathVariable String ownerName, @RequestBody PatchDog patchDog){
        dogManagementService.modifyDog(name, ownerName, ownerPhoneNumber, patchDog);
    }

    @PatchMapping("/dogs/ModifyDogKind/{name}/{ownerPhoneNumber}/{ownerName}")
    public void ModifyDogKind(@PathVariable String name, @PathVariable String ownerPhoneNumber, @PathVariable String ownerName, @RequestBody PatchDogKind patchDogs){
        dogManagementService.modifyDogKind(name, ownerName, ownerPhoneNumber, patchDogs);
    }

}