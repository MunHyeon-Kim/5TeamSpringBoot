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

    public List<Dog> getAllDogs() {
        return dogRepository.findAllDog();
    }

}
