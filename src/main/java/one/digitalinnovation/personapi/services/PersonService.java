package one.digitalinnovation.personapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.personapi.dto.request.PersonDTO;
import one.digitalinnovation.personapi.dto.response.MessageResponseDTO;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.mappers.PersonMapper;
import one.digitalinnovation.personapi.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

	
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	public Optional<Person> findById(Long personId) {
		
		return personRepository.findById(personId);
	}
	

	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		
        Person personToSave = personMapper.toModel(personDTO);

        Person savedPerson = personRepository.save(personToSave);
        return MessageResponseDTO(savedPerson.getId(), "Created person with ID ");			
	}
	
}
