package one.digitalinnovation.personapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.personapi.dto.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repositories.PersonRepository;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

	@Autowired
	private PersonRepository personRepository;
	
	
	@PostMapping
	public MessageResponseDTO createPerson(@RequestBody Person person) {
		
		Person savePerson = personRepository.save(person);
		return MessageResponseDTO
				.builder()
				.message("Created person with ID " + savePerson.getId())
				.build();
				
	}

	
	
	
}
