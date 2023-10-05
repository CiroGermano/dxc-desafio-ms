package com.ciromoraes.dxcdesafioms.dto.converters;

import com.ciromoraes.dxcdesafioms.dto.person.PersonUpdateDto;
import com.ciromoraes.dxcdesafioms.entities.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonUpdateDtoConverter {

    private final static ObjectMapper mapper = new ObjectMapper();

    public static PersonUpdateDto convertToDto(Person person) {
        return mapper.convertValue(person, PersonUpdateDto.class);
    }

    public static Person convertToEntity(PersonUpdateDto personUpdateDto) {
        return mapper.convertValue(personUpdateDto, Person.class);
    }

}
