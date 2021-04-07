package org.cnu.realcoding.repository;

import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.exception.DogNotfoundException;
import org.cnu.realcoding.exception.DogfoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DogRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public boolean exists(String name,String ownerName,String ownerPhoneNumber) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        query.addCriteria(Criteria.where("ownerName").is(ownerName));
        query.addCriteria(Criteria.where("ownerPhoneNumber").is(ownerPhoneNumber));
        return mongoTemplate.exists(query, Dog.class);
    }

    public void insertDog(Dog dog) {
        if(!exists(dog.getName(),dog.getOwnerName(),dog.getOwnerPhoneNumber()))
            mongoTemplate.insert(dog);
        else
            throw new DogfoundException();
    }

    public List<Dog> findAllDog() {
        return mongoTemplate.findAll(Dog.class);
    }

}
