package com.example.demo.mapper;

import com.example.demo.dto.PersonDto;
import com.example.demo.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public abstract class PersonMapper {

    @Mapping(source = "firstname", target = "givenname")
    @Mapping(source = "lastname", target = "surname")
    public abstract PersonDto toPersonDto(Person person);

    // todo add children mapping

}
