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
       // dogs.add(dog);
    }



    public Dog getDogByName(String name) {
//        if(!dogRepository.exists(name)){
//            throw new DogNotfoundException();
//        }
        Dog dog  = dogRepository.findDogByName(name);

        if(dog == null){
            throw new DogNotfoundException();
        }

        return dog;
 //       throw new DogNotfoundException();
    }

    public Dog getDogByOwnerName(String ownerName){
        Dog dog = dogRepository.findDogByOwnerName(ownerName);

        if(dog == null){
            throw new DogNotfoundException();
        }

        return dog;

    }

    public Dog getDogByOwnerPhoneNumber(String ownerPhoneNumber){
        Dog dog = dogRepository.findDogByOwnerPhoneNumber(ownerPhoneNumber);

        if(dog == null){
            throw new DogNotfoundException();
        }

        return dog;

    }

    public Dog getDogByUniqueKey(String name,String ownerName,String ownerPhoneNumber){
        Dog dog = dogRepository.findDogByUniqueKey(name,ownerName,ownerPhoneNumber);

        if(dog == null){
            throw new DogNotfoundException();
        }

        return dog;
    }

    public List<Dog> getAllDogs() {
        return dogRepository.findAllDog();
    }
}
