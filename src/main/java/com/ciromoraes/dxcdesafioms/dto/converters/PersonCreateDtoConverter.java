package com.ciromoraes.dxcdesafioms.dto.converters;

import com.ciromoraes.dxcdesafioms.dto.person.PersonCreateDto;
import com.ciromoraes.dxcdesafioms.entities.Person;
import org.modelmapper.ModelMapper;

public class PersonCreateDtoConverter {
    private final static ModelMapper modelMapper = new ModelMapper();

    public static PersonCreateDto convertToDto(Person person) {
        return modelMapper.map(person, PersonCreateDto.class);
    }

    public static Person convertToEntity(PersonCreateDto personCreateDto) {
        return modelMapper.map(personCreateDto, Person.class);
    }

}
