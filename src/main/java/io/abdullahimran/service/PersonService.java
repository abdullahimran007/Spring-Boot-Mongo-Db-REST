package io.abdullahimran.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.abdullahimran.model.Person;
import io.abdullahimran.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public Person createPerson(String firstName, String lastName,int age) {
		return personRepository.save(new Person(firstName,lastName,age));
		}
	
	public  List<Person> getAll(){
		return personRepository.findAll();
	}
	
	public Person getByFirstName(String firstName) {
		return personRepository.findByFirstName(firstName);
		
	}
	
	public Person getByAge(int age) {
		return personRepository.findByAge(age);
	}
	
	public void deleteAll() {
		personRepository.deleteAll();
	}
	public void deletePerson(String firstName) {
		Person p=personRepository.findByFirstName(firstName);
		personRepository.delete(p);
	}
	
	public Person updatePerson(String firstName, String lastName, int age) {
		Person p=personRepository.findByFirstName(firstName);
		p.setAge(age);
		p.setLastName(lastName);
		return p;
	}
	
}
