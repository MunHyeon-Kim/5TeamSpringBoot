package org.cnu.realcoding.repository;

import ch.qos.logback.classic.Logger;
import org.cnu.realcoding.domain.Dog;
import org.cnu.realcoding.exception.DogNotfoundException;
import org.cnu.realcoding.exception.DogfoundException;
import org.cnu.realcoding.vo.PatchDog;
import org.cnu.realcoding.vo.PatchDogKind;
import org.cnu.realcoding.vo.PatchRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DogRepository {

    @Autowired
    private MongoTemplate mongoTemplate;



    public List<Dog> findDogByOwnerPhoneNumber(String ownerPhoneNumber) {
        Query query = new Query();
        query.addCriteria(Criteria.where("ownerPhoneNumber").is(ownerPhoneNumber));
        if (!mongoTemplate.exists(query, Dog.class))
            throw new DogNotfoundException();
        else
        return mongoTemplate
                .find(
                        Query.query(Criteria.where("ownerPhoneNumber").is(ownerPhoneNumber)),
                        Dog.class);
    }

    public boolean exists(String name,String ownerName,String ownerPhoneNumber) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        query.addCriteria(Criteria.where("ownerName").is(ownerName));
        query.addCriteria(Criteria.where("ownerPhoneNumber").is(ownerPhoneNumber));
        return mongoTemplate.exists(query, Dog.class);
    }

    public List<Dog> findDogByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        if (!mongoTemplate.exists(query, Dog.class))
            throw new DogNotfoundException();
         else
            return mongoTemplate.find(Query.query(Criteria.where("name").is(name)), Dog.class);
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

    public List<Dog> findDogByOwnerName(String ownerName) {
        Query query = new Query();
        query.addCriteria(Criteria.where("ownerName").is(ownerName));
        if (!mongoTemplate.exists(query, Dog.class))
            throw new DogNotfoundException();
        else
            return mongoTemplate.find(Query.query(Criteria.where("ownerName").is(ownerName)),Dog.class);

    }




    public Dog findDogByUniqueKey(String name,String ownerPhoneNumber, String ownerName ) {

        if(!exists(name,ownerName,ownerPhoneNumber))
            return null;

        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        query.addCriteria(Criteria.where("ownerName").is(ownerName));
        query.addCriteria(Criteria.where("ownerPhoneNumber").is(ownerPhoneNumber));

        return mongoTemplate.findOne(query, Dog.class);
    }


    public void modifyDog(String name, String ownerName, String ownerPhoneNumber, PatchDog patchDog) {
        if(exists(name,ownerName,ownerPhoneNumber)) {
            Query query = new Query();
            Update update = new Update();
            query.addCriteria(Criteria.where("name").is(name));
            query.addCriteria(Criteria.where("ownerName").is(ownerName));
            query.addCriteria(Criteria.where("ownerPhoneNumber").is(ownerPhoneNumber));
            if (patchDog.getName() != null) {
                update.set("name", patchDog.getName());
            }
            if (patchDog.getKind() != null) {
                update.set("kind", patchDog.getKind());
            }
            if (patchDog.getOwnerName() != null) {
                update.set("ownerName", patchDog.getOwnerName());
            }
            if (patchDog.getOwnerPhoneNumber() != null) {
                update.set("ownerPhoneNumber", patchDog.getOwnerPhoneNumber());
            }
            mongoTemplate.updateFirst(query, update, Dog.class);
        }
    }

    public void modifyDogKind(String name, String ownerName, String ownerPhoneNumber, PatchDogKind patchDogs) {
        if(exists(name,ownerName,ownerPhoneNumber)) {
            Query query = new Query();
            Update update = new Update();
            query.addCriteria(Criteria.where("name").is(name));
            query.addCriteria(Criteria.where("ownerName").is(ownerName));
            query.addCriteria(Criteria.where("ownerPhoneNumber").is(ownerPhoneNumber));
            if (patchDogs.getKind() != null) {
                update.set("kind", patchDogs.getKind());
            }
            mongoTemplate.updateFirst(query, update, Dog.class);
        }
    }

    public void modifyRecords(String name, String ownerName, String ownerPhoneNumber, PatchRecords patchRecords) {
        if(exists(name,ownerName,ownerPhoneNumber)) {

            Query query = new Query();
            Update update = new Update();
            // 기존 DOG찾기
            query.addCriteria(Criteria.where("name").is(name));
            query.addCriteria(Criteria.where("ownerName").is(ownerName));
            query.addCriteria(Criteria.where("ownerPhoneNumber").is(ownerPhoneNumber));


            update.push("medicalRecords", patchRecords.getMedicalRecords());

            mongoTemplate.updateFirst(query, update, Dog.class);
        }
    }
}
