package com.ciromoraes.dxcdesafioms.controllers;

import com.ciromoraes.dxcdesafioms.dto.converters.PersonCreateDtoConverter;
import com.ciromoraes.dxcdesafioms.dto.converters.PersonResponseDtoConverter;
import com.ciromoraes.dxcdesafioms.dto.converters.PersonUpdateDtoConverter;
import com.ciromoraes.dxcdesafioms.dto.person.PersonCreateDto;
import com.ciromoraes.dxcdesafioms.dto.person.PersonResponseDto;
import com.ciromoraes.dxcdesafioms.dto.person.PersonUpdateDto;
import com.ciromoraes.dxcdesafioms.entities.Person;
import com.ciromoraes.dxcdesafioms.services.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PersonControllerUnitTest {

    @Spy
    @InjectMocks
    PersonController personController;

    @Mock
    PersonService personService;

    @Autowired
    PersonController controller;

    @Test
    public void createPerson() {
        // setpup
        PersonCreateDto newPersonDto = new PersonCreateDto("aNickName", "aFirstName", "aLastName",
                "aEmail", "aCpf");
        Person newPerson = PersonCreateDtoConverter.convertToEntity(newPersonDto);
        newPerson.setId(1L);
        when(personService.createPerson(newPersonDto)).thenReturn(newPerson);

        // act
        PersonResponseDto created = personController.createPerson(newPersonDto);

        // assert
        Assertions.assertNotNull(created);
    }

    @Test
    public void findAll() {
        // setup
        PersonResponseDto aPersonDto = new PersonResponseDto(1L, "aNickName", "aFirstName",
                "aLastName", "aEmail", "aCpf");
        PersonResponseDto bPersonDto = new PersonResponseDto(2L, "bNickName", "bFirstName",
                "bLastName", "bEmail", "bCpf");
        List<PersonResponseDto> personsDto = Arrays.asList(aPersonDto, bPersonDto);
        List<Person> persons = PersonResponseDtoConverter.convertToEntity(personsDto);
        when(personService.findAll()).thenReturn(persons);

        // act
        List<PersonResponseDto> foundPersons = personController.findAll();

        // assert
        Assertions.assertNotNull(foundPersons);
    }

    @Test
    public void findById() {
        // setup
        Person aPerson = new Person(1L, "aNickName", "aFirstName",
                "aLastName", "aEmail", "aCpf");
        when(personService.findById(1L)).thenReturn(aPerson);

        // act
        PersonResponseDto foundPerson = personController.findById(1L);

        // assert
        Assertions.assertNotNull(foundPerson);
    }

    @Test
    public void updatePerson() {
        // setup
        Person aPerson = new Person(1L, "aNickName", "aFirstName",
                "aLastName", "aEmail", "aCpf");
        PersonUpdateDto personWithUpdatedNameDto = new PersonUpdateDto("aNickName", "aUpdatedName",
                "aLastName", "aEmail");
        Person personWithUpdatedName = PersonUpdateDtoConverter.convertToEntity(personWithUpdatedNameDto);
        personWithUpdatedName.setId(1L);
        when(personService.findById(1L)).thenReturn(aPerson);
        when(personService.update(1L, personWithUpdatedNameDto)).thenReturn(personWithUpdatedName);

        // act
        PersonResponseDto personAlreadyInDb = personController.findById(1L);
        PersonResponseDto updatedPerson = personController.update(1L, personWithUpdatedNameDto);

        // assert
        Assertions.assertNotNull(updatedPerson);
        Assertions.assertEquals(personAlreadyInDb.getFirstName(), "aFirstName");
        Assertions.assertEquals(updatedPerson.getFirstName(), "aUpdatedName");
        verify(personController, times(1)).update(1L, personWithUpdatedNameDto);
    }

    @Test
    public void deletePerson() {
        // setup
        Long personId = 1L;

        // act
        personController.delete(personId);

        // assert
        verify(personController, times(1)).delete(1L);
    }
}
