package com.example.mapstruct.custom_methods;

import com.example.mapstruct.common.dto.PersonWithChildIdsDto;
import com.example.mapstruct.common.entity.PersonWithChildrenEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;

@Mapper(componentModel = ComponentModel.SPRING)
public abstract class PersonWithChildrenMapper {

    @Mapping(source = "firstname", target = "givenname")
    @Mapping(source = "lastname", target = "surname")
    @Mapping(source = "children", target = "childrenIds")
    public abstract PersonWithChildIdsDto toPersonDto(PersonWithChildrenEntity person);


    public List<Long> toChildrenIds(List<PersonWithChildrenEntity> children) {
        return children.stream().map(PersonWithChildrenEntity::getId).toList();
    }


}
