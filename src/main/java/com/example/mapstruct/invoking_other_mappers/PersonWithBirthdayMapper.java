package com.example.mapstruct.invoking_other_mappers;

import com.example.mapstruct.common.dto.PersonWithBirthdayDto;
import com.example.mapstruct.common.entity.PersonWithBirthdayEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    uses = DateMapper.class
)
public abstract class PersonWithBirthdayMapper {

    @Mapping(source = "firstname", target = "givenname")
    @Mapping(source = "lastname", target = "surname")
    public abstract PersonWithBirthdayDto toPersonDto(PersonWithBirthdayEntity personEntity);

    @InheritInverseConfiguration
    public abstract PersonWithBirthdayEntity toPerson(PersonWithBirthdayDto personDto);


}


