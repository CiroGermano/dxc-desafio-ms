package com.ciromoraes.dxcdesafioms.controllers;

import com.ciromoraes.dxcdesafioms.dto.converters.PersonResponseDtoConverter;
import com.ciromoraes.dxcdesafioms.dto.person.PersonCreateDto;
import com.ciromoraes.dxcdesafioms.dto.person.PersonResponseDto;
import com.ciromoraes.dxcdesafioms.dto.person.PersonUpdateDto;
import com.ciromoraes.dxcdesafioms.entities.Person;
import com.ciromoraes.dxcdesafioms.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    PersonService personService;

    @Autowired
    PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonResponseDto createPerson(@RequestBody PersonCreateDto personCreateDto) {
        Person createdPerson = personService.createPerson(personCreateDto);
        return PersonResponseDtoConverter.convertToDto(createdPerson);
    }

    @GetMapping
    public List<PersonResponseDto> findAll() {
        List<Person> persons = personService.findAll();
        return PersonResponseDtoConverter.convertToDto(persons);
    }

    @GetMapping("/{id}")
    public PersonResponseDto findById(@PathVariable long id) {
        Person person = personService.findById(id);
        return PersonResponseDtoConverter.convertToDto(person);
    }

    @PutMapping("/{id}")
    public PersonResponseDto update(@PathVariable Long id, @RequestBody PersonUpdateDto personUpdateDto) {
        Person updatedPerson = personService.update(id, personUpdateDto);
        return PersonResponseDtoConverter.convertToDto(updatedPerson);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personService.delete(id);
    }

}
