package org.cnu.realcoding.service;

import lombok.Getter;
import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.exception.DogNotfoundException;
import org.cnu.realcoding.repository.DogRepository;
import org.cnu.realcoding.vo.PatchDog;
import org.cnu.realcoding.vo.PatchDogKind;
import org.cnu.realcoding.vo.PatchRecords;
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



    public List<Dog> getDogByName(String name) {
//        if(!dogRepository.exists(name)){
//            throw new DogNotfoundException();
//        }
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



    public Dog getDogByUniqueKey(String name,String ownerName,String ownerPhoneNumber){
        Dog dog = dogRepository.findDogByUniqueKey(name,ownerPhoneNumber,ownerName);

        if(dog == null){
            throw new DogNotfoundException();
        }

        return dog;
    }

    public List<Dog> getAllDogs() {
        return dogRepository.findAllDog();
    }

    public List<Dog> getDogByOwnerPhoneNumber(String ownerPhoneNumber) {
        List<Dog> dog  = dogRepository.findDogByOwnerPhoneNumber(ownerPhoneNumber);

        if(dog == null){
            throw new DogNotfoundException();
        }

        return dog;
    }


    public void modifyDog(String name, String ownerName, String ownerPhoneNumber, PatchDog patchDog) {
        dogRepository.modifyDog(name,ownerName,ownerPhoneNumber, patchDog);
    }

}
