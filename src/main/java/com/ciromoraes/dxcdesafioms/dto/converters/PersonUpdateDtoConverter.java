package com.ciromoraes.dxcdesafioms.dto.converters;

import com.ciromoraes.dxcdesafioms.dto.person.PersonCreateDto;
import com.ciromoraes.dxcdesafioms.dto.person.PersonUpdateDto;
import com.ciromoraes.dxcdesafioms.entities.Person;
import org.modelmapper.ModelMapper;

public class PersonUpdateDtoConverter {
    private final static ModelMapper modelMapper = new ModelMapper();

    public static PersonUpdateDto convertToDto(Person person) {
        return modelMapper.map(person, PersonUpdateDto.class);
    }

    public static Person convertToEntity(PersonUpdateDto personUpdateDto) {
        return modelMapper.map(personUpdateDto, Person.class);
    }

}
