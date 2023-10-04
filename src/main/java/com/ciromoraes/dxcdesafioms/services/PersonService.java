package com.ciromoraes.dxcdesafioms.services;

import com.ciromoraes.dxcdesafioms.dto.converters.PersonCreateDtoConverter;
import com.ciromoraes.dxcdesafioms.dto.converters.PersonUpdateDtoConverter;
import com.ciromoraes.dxcdesafioms.dto.person.PersonCreateDto;
import com.ciromoraes.dxcdesafioms.dto.person.PersonUpdateDto;
import com.ciromoraes.dxcdesafioms.entities.Person;
import com.ciromoraes.dxcdesafioms.exceptions.person.CpfAlreadyExistsException;
import com.ciromoraes.dxcdesafioms.exceptions.person.PersonNotFoundException;
import com.ciromoraes.dxcdesafioms.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person createPerson(PersonCreateDto personCreateDto) {
        Person person = PersonCreateDtoConverter.convertToEntity(personCreateDto);
        cpfAlreadyExists(person);
        return personRepository.save(person);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(long l) {
        return personRepository.findById(l).get();
    }

    public Person update(Long id, PersonUpdateDto personUpdateDto) throws PersonNotFoundException {
        Optional<Person> foundPerson = personRepository.findById(id);
        if (foundPerson.isEmpty()){
            throw new PersonNotFoundException(id);
        }
        Person person = PersonUpdateDtoConverter.convertToEntity(personUpdateDto);
        person.setId(id);
        person.setCpf(foundPerson.get().getCpf());
        return personRepository.save(person);
    }

    public void delete(Long personId) throws PersonNotFoundException {
        boolean existsPerson = personRepository.existsById(personId);
        if(!existsPerson){
            throw new PersonNotFoundException(personId);
        }

        personRepository.deleteById(personId);
    }

    private void cpfAlreadyExists(Person person) throws CpfAlreadyExistsException {
        if (personRepository.findByCpf(person.getCpf()).isPresent()) {
            throw new CpfAlreadyExistsException(person);
        }
    }


}
