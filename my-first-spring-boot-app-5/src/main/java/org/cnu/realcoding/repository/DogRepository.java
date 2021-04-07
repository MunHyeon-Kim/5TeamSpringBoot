package org.cnu.realcoding.repository;

import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.exception.DogfoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DogRepository {

    @Autowired
    private MongoTemplate mongoTemplate;



    public Dog findDogByName(String name) {
        return mongoTemplate
                .findOne(
                Query.query(Criteria.where("name").is(name)),
                Dog.class);

    }

    public boolean exists(String name,String ownerName,String ownerPhoneNumber) {
        return mongoTemplate.exists(Query.query(Criteria.where("name").is(name)), Dog.class);
//                &mongoTemplate.exists(Query.query(Criteria.where("ownerName").is(ownerName)), Dog.class)
//                &mongoTemplate.exists(Query.query(Criteria.where("ownerPhoneNumber").is(ownerPhoneNumber)), Dog.class);
    }

    public void insertDog(Dog dog) {
        if(!exists(dog.getName(),dog.getOwenerName(),dog.getOwenerPhoneNumber()))
            mongoTemplate.insert(dog);
        else
            throw new DogfoundException();
    }

    public List<Dog> findAllDog() {
        return mongoTemplate.findAll(Dog.class);
    }

    public Dog findDogByOwnerName(String ownerName) {
        return mongoTemplate
                .findOne(
                        Query.query(Criteria.where("ownerName").is(ownerName)),
                        Dog.class);
    }

    public Dog findDogByOwnerPhoneNumber(String ownerPhoneNumber) {
        return mongoTemplate
                .findOne(
                        Query.query(Criteria.where("ownerPhoneNumber").is(ownerPhoneNumber)),
                        Dog.class);
    }

    public Dog findDogByUniqueKey(String name, String ownerName, String ownerPhoneNumber) {
        if(!exists(name,ownerName,ownerPhoneNumber)){
            return null;
        }
        else
            return null;
    }
}
