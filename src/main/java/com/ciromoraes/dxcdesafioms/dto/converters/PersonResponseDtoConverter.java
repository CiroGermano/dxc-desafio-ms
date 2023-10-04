package com.ciromoraes.dxcdesafioms.dto.converters;

import com.ciromoraes.dxcdesafioms.dto.person.PersonCreateDto;
import com.ciromoraes.dxcdesafioms.dto.person.PersonResponseDto;
import com.ciromoraes.dxcdesafioms.entities.Person;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class PersonResponseDtoConverter {

    private final static ModelMapper modelMapper = new ModelMapper();

    public static PersonResponseDto convertToDto(Person person) {
        return modelMapper.map(person, PersonResponseDto.class);
    }

    public static List<PersonResponseDto> convertToDto(List<Person> persons) {
        return persons
                .stream()
                .map(person -> modelMapper.map(person, PersonResponseDto.class))
                .collect(Collectors.toList());
    }

    public static Person convertToEntity(PersonResponseDto personResponseDto) {
        return modelMapper.map(personResponseDto, Person.class);
    }

    public static List<Person> convertToEntity(List<PersonResponseDto> personsResponseDto) {
        return personsResponseDto
                .stream()
                .map(personResponseDto -> modelMapper.map(personResponseDto, Person.class))
                .collect(Collectors.toList());
    }
}
