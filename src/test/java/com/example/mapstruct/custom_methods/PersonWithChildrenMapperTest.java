package com.example.mapstruct.custom_methods;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.mapstruct.common.dto.PersonWithChildIdsDto;
import com.example.mapstruct.common.entity.PersonWithChildrenEntity;
import java.util.List;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class PersonWithChildrenMapperTest {

    final PersonWithChildrenMapper personMapper = Mappers.getMapper(PersonWithChildrenMapper.class);

    @Test
    void toPersonDto() {

        final PersonWithChildrenEntity person = PersonWithChildrenEntity.builder()
            .id(1L)
            .firstname("Max")
            .lastname("Mustermann")
            .children(List.of(
                PersonWithChildrenEntity.builder()
                    .id(11L)
                    .firstname("Mäxle")
                    .lastname("Mustermann")
                    .build(),
                PersonWithChildrenEntity.builder()
                    .id(12L)
                    .firstname("Maxime")
                    .lastname("Mustermann")
                    .build()

            ))
            .build();

        final PersonWithChildIdsDto result = personMapper.toPersonDto(person);

        System.out.println(ReflectionToStringBuilder.toString(result, ToStringStyle.MULTI_LINE_STYLE));

        assertAll(
            () -> assertThat(result.getId()).isEqualTo(1L),
            () -> assertThat(result.getGivenname()).isEqualTo("Max"),
            () -> assertThat(result.getSurname()).isEqualTo("Mustermann"),
            () -> assertThat(result.getChildrenIds()).containsExactlyInAnyOrder(11L, 12L)
        );

    }

}
