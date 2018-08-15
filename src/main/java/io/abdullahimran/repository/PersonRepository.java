package io.abdullahimran.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.abdullahimran.model.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
   public Person findByFirstName(String firstName);
   public Person findByAge(int age);
}
