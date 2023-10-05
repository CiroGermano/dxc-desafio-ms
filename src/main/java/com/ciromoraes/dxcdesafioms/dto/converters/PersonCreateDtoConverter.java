package com.ciromoraes.dxcdesafioms.dto.converters;

import com.ciromoraes.dxcdesafioms.dto.person.PersonCreateDto;
import com.ciromoraes.dxcdesafioms.entities.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonCreateDtoConverter {
    private final static ObjectMapper mapper = new ObjectMapper();

    public static PersonCreateDto convertToDto(Person person) {
        return mapper.convertValue(person, PersonCreateDto.class);
    }

    public static Person convertToEntity(PersonCreateDto personCreateDto) {
        return mapper.convertValue(personCreateDto, Person.class);
    }

}
