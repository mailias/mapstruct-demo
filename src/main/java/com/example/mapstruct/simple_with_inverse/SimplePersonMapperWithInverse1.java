package com.example.mapstruct.simple_with_inverse;

import com.example.mapstruct.common.dto.SimplePersonDto;
import com.example.mapstruct.common.entity.SimplePersonEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface SimplePersonMapperWithInverse1 {

    @Mapping(source = "firstname", target = "givenname")
    @Mapping(source = "lastname", target = "surname")
    SimplePersonDto toPersonDto(SimplePersonEntity person);

    @InheritInverseConfiguration
    @Mapping(target = "foo", ignore = true)
    SimplePersonEntity toPerson(SimplePersonDto personDto);


}
