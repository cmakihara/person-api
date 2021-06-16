package one.digitalinnovation.personapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.services.PersonService;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

	
	@Autowired
	private PersonService personService;
	
	@GetMapping
	public List<Person> findAll() {
		return personService.findAll();
	}
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public MessageResponseDTO createPerson(@Valid @RequestBody PersonDTO personDTO) {
		
		return 	personService.createPerson(personDTO);
	}

	
	
	
}
