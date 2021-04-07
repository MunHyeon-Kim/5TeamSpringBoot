package org.cnu.realcoding.service;

import lombok.Getter;
import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.exception.DogNotfoundException;
import org.cnu.realcoding.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DogManagementService {

    @Autowired
    private DogRepository dogRepository;

    public void insertDog(Dog dog) {
        dogRepository.insertDog(dog);
    }



    public List<Dog> getDogByName(String name) {
        List<Dog> dog  = dogRepository.findDogByName(name);
        if(dog == null){
            throw new DogNotfoundException();
        }
        return dog;
    }

    public List<Dog> getDogByOwnerName(String ownerName){
        List<Dog> dog = dogRepository.findDogByOwnerName(ownerName);

        if(dog == null){
            throw new DogNotfoundException();
        }

        return dog;

    }


    public List<Dog> getAllDogs() {
        return dogRepository.findAllDog();
    }

}
