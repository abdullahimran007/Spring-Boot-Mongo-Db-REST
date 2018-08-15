package io.abdullahimran.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.abdullahimran.model.Person;
import io.abdullahimran.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping(method=RequestMethod.POST,value="/create")
	public Person create(@RequestParam String firstName,@RequestParam String lastName,@RequestParam int age ) {
	return	personService.createPerson(firstName, lastName, age);
	}
	
	@RequestMapping("/get")
	public List<Person> getAll(){
		return personService.getAll();
	}
	
	@RequestMapping("/get/{firstName}")
	public Person getByFirstName(@PathVariable String firstName){
		return personService.getByFirstName(firstName);
	}
	
	@RequestMapping("/get/{age}")
	public Person getByAge(@PathVariable int age){
		return personService.getByAge(age);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete")
	public void deleteAll() {
		personService.deleteAll();
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{firstName}")
	public void deleteAll(@PathVariable String firstName) {
		personService.deletePerson(firstName);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/update")
	public Person updatePerson(@RequestParam String firstName,@RequestParam String lastName,@RequestParam int age) {
		return personService.updatePerson(firstName, lastName, age);
	}
}
