package com.ciromoraes.dxcdesafioms.dto.converters;

import com.ciromoraes.dxcdesafioms.dto.person.PersonResponseDto;
import com.ciromoraes.dxcdesafioms.entities.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PersonResponseDtoConverter {

    private final static ObjectMapper mapper = new ObjectMapper();

    public static PersonResponseDto convertToDto(Person person) {
        return mapper.convertValue(person, PersonResponseDto.class);
    }

    public static List<PersonResponseDto> convertToDto(List<Person> persons) {
        return persons
            .stream()
            .map(person -> {
                return mapper.convertValue(person, PersonResponseDto.class);
            })
            .collect(Collectors.toList());
    }

    public static Person convertToEntity(PersonResponseDto personResponseDto) {
        return mapper.convertValue(personResponseDto, Person.class);
    }

    public static List<Person> convertToEntity(List<PersonResponseDto> personsResponseDto) {
        return personsResponseDto
            .stream()
            .map(person -> {
                return mapper.convertValue(person, Person.class);
            })
            .collect(Collectors.toList());
    }
}
