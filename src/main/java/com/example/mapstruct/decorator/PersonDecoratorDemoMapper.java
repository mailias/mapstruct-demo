package com.example.mapstruct.decorator;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper
@DecoratedWith(PersonMapperDecorator.class)
public interface PersonDecoratorDemoMapper {
    PersonDto toPersonDto(UserDto person);

}
