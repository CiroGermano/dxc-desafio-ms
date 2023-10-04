package com.ciromoraes.dxcdesafioms.services;

import com.ciromoraes.dxcdesafioms.dto.converters.PersonCreateDtoConverter;
import com.ciromoraes.dxcdesafioms.dto.person.PersonCreateDto;
import com.ciromoraes.dxcdesafioms.dto.person.PersonUpdateDto;
import com.ciromoraes.dxcdesafioms.entities.Person;
import com.ciromoraes.dxcdesafioms.exceptions.person.CpfAlreadyExistsException;
import com.ciromoraes.dxcdesafioms.exceptions.person.PersonNotFoundException;
import com.ciromoraes.dxcdesafioms.repositories.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceUnitTest {

    @Spy
    @InjectMocks
    PersonService personService;

    @Mock
    PersonRepository personRepository;

    @Test
    public void createPerson() {
        // setup
        Person aPerson = new Person(1L, "aNickName", "aFirstName", "aLastName",
                "aEmail", "aCpf");
        PersonCreateDto personCreateDto = PersonCreateDtoConverter.convertToDto(aPerson);
        when(personRepository.save(Mockito.any(Person.class))).thenReturn(aPerson);
        // act
        Person createdPerson = personService.createPerson(personCreateDto);
        // assert
        Assertions.assertNotNull(createdPerson);
        Assertions.assertTrue(aPerson.equals(createdPerson));
    }

    @Test
    public void findAll() {
        // setup
        Person aPerson = new Person(1L, "aNickName", "aFirstName", "aLastName",
                "aEmail", "aCpf");
        Person bPerson = new Person(2L, "bNickName", "bFirstName", "bLastName",
                "bEmail", "bCpf");
        List<Person> persons = Arrays.asList(aPerson, bPerson);
        when(personRepository.findAll()).thenReturn(persons);

        // act
        List<Person> foundedPersons = personRepository.findAll();
        // assert
        Assertions.assertNotNull(foundedPersons);
        Assertions.assertTrue(persons.equals(foundedPersons));
    }

    @Test
    public void findById() {
        // setup
        Person aPerson = new Person(1L, "aNickName", "aFirstName", "aLastName",
                "aEmail", "aCpf");
        when(personRepository.findById(1L)).thenReturn(Optional.of(aPerson));

        // act
        Person foundedPerson = personService.findById(1L);

        // assert
        Assertions.assertNotNull(foundedPerson);
        Assertions.assertTrue(aPerson.equals(foundedPerson));
    }

    @Test
    public void updatePerson() {
        // setup
        Person foundedPerson = new Person(1L, "aNickName", "aFirstName", "aLastName",
                "aEmail", "aCpf");
        when(personRepository.findById(1L)).thenReturn(Optional.of(foundedPerson));
        Person modifiedPerson = new Person(1L, "modifiedNickName", "modifiedFirstName",
                "modifiedLastName", "aEmail", "aCpf");
        when(personRepository.save(Mockito.any(Person.class))).thenReturn(modifiedPerson);
        PersonUpdateDto personUpdateDto = new PersonUpdateDto();
        personUpdateDto.setNickName("modifiedNickName");
        personUpdateDto.setLastName("modifiedFirstName");

        // act
        Person updatedPerson = personService.update(1L, personUpdateDto);

        // assert
        Assertions.assertNotNull(updatedPerson);
        Assertions.assertTrue(foundedPerson.equals(updatedPerson));
        Assertions.assertTrue("modifiedFirstName".equals(updatedPerson.getFirstName()));
        Assertions.assertTrue("modifiedLastName".equals(updatedPerson.getLastName()));
    }

    @Test
    public void deletePerson() {
        // setup
        Long personId = 1L;
        when(personRepository.existsById(personId)).thenReturn(true);
        doNothing().when(personRepository).deleteById(personId);

        // act
        personService.delete(1L);

        // assert
        verify(personService, times(1)).delete(personId);
    }

    @Test
    public void throwCpfAlreadyExistsExceptionWhenCreatePerson() {
        // setup
        Person person = new Person(1L, "aNickName", "aFirstName", "aLastName",
                "aEmail@email.com", "aCpf");
        PersonCreateDto personCreateDto = PersonCreateDtoConverter.convertToDto(person);
        when(personRepository.findByCpf("aCpf")).thenReturn(Optional.of(person));

        // act
        Throwable throwable = assertThrows(CpfAlreadyExistsException.class,
                () -> personService.createPerson(personCreateDto));

        // assert
        Assertions.assertEquals(CpfAlreadyExistsException.class, throwable.getClass());
    }

    @Test
    public void throwPersonNotFoundExceptionWhenUpdatePerson() {
        // setup
        PersonUpdateDto personUpdateDto = new PersonUpdateDto();
        personUpdateDto.setNickName("modifiedNickName");
        personUpdateDto.setLastName("modifiedFirstName");
        when(personRepository.findById(any(Long.class))).thenReturn(Optional.empty());

        // act
        Throwable throwable = assertThrows(PersonNotFoundException.class,
                () -> personService.update(1L, personUpdateDto));

        // assert
        Assertions.assertEquals(PersonNotFoundException.class, throwable.getClass());
    }
}
