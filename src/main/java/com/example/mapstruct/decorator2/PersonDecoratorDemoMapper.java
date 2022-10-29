package com.example.mapstruct.decorator2;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper
@DecoratedWith(PersonMapperDecorator.class)
public interface PersonDecoratorDemoMapper {
    Person toPerson(PersonDto person);

    PersonDto toPersonDto(Person person);

}
