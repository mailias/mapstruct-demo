package com.example.mapstruct.update;

import com.example.mapstruct.common.dto.SimplePersonDto;
import com.example.mapstruct.common.entity.SimplePersonEntity;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = ComponentModel.SPRING)
public interface PersonMapperWithUpdate {

    @Mapping(source = "firstname", target = "givenname")
    @Mapping(source = "lastname", target = "surname")
    SimplePersonDto toPersonDto(SimplePersonEntity person);

    @InheritInverseConfiguration
    @Mapping(target = "foo", ignore = true)
    SimplePersonEntity toPerson(SimplePersonDto personDto);


    // hier Update:
    @InheritConfiguration
    SimplePersonEntity updatePersonFromPersonDto(SimplePersonDto personDto, @MappingTarget SimplePersonEntity personEntity);


}
