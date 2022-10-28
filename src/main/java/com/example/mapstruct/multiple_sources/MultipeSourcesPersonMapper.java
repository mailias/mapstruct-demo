package com.example.mapstruct.multiple_sources;

import com.example.mapstruct.common.dto.PersonWithAddressDto;
import com.example.mapstruct.common.entity.AddressEntity;
import com.example.mapstruct.common.entity.SimplePersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public interface MultipeSourcesPersonMapper {

    @Mapping(target = "id", source = "person.id")
    @Mapping(target = "givenname", source = "person.firstname")
    @Mapping(target = "surname", source = "person.lastname")
    @Mapping(target = "street", source = "address.street")
    @Mapping(target = "housenumber", source = "address.housenumber")
    @Mapping(target = "zipcode", source = "address.zipcode")
    @Mapping(target = "city", source = "address.city")
    PersonWithAddressDto toDto(SimplePersonEntity person, AddressEntity address);

}
