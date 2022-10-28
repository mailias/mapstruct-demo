package com.example.mapstruct.map_to_bean;

import com.example.mapstruct.common.dto.PersonWithAddressDto;
import java.util.Map;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface MapToPersonMapper {

    @Mapping(target = "givenname", source = "firstname")
    @Mapping(target = "surname", source = "lastname")
    PersonWithAddressDto toDto(Map<String, String> person);

}
