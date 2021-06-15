package one.digitalinnovation.personapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.personapi.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
