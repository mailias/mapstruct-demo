package com.example.mapstruct.simple_with_inverse;

import com.example.mapstruct.common.dto.SimplePersonDto;
import com.example.mapstruct.common.entity.SimplePersonEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public abstract class SimplePersonMapperWithInverse2 {

    @Mapping(source = "firstname", target = "givenname")
    @Mapping(source = "lastname", target = "surname")
    public abstract SimplePersonDto toPersonDto(SimplePersonEntity person);

    @InheritInverseConfiguration
    @Mapping(target = "foo", ignore = true)
    public abstract SimplePersonEntity toPerson(SimplePersonDto personDto);


}
