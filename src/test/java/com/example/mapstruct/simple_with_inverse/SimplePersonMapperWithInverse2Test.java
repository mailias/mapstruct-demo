package com.example.mapstruct.simple_with_inverse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.example.mapstruct.common.dto.SimplePersonDto;
import com.example.mapstruct.common.entity.SimplePersonEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class SimplePersonMapperWithInverse2Test {

    final SimplePersonMapperWithInverse2 personMapper = Mappers.getMapper(SimplePersonMapperWithInverse2.class);

    @Test
    void toPersonDto() {

        final SimplePersonEntity person = SimplePersonEntity.builder()
            .firstname("Max")
            .lastname("Mustermann")
            .foo("not ignored")
            .build();

        final SimplePersonDto personDto = personMapper.toPersonDto(person);

        assertAll(
            () -> assertThat(personDto.getGivenname()).isEqualTo("Max"),
            () -> assertThat(personDto.getSurname()).isEqualTo("Mustermann"),
            () -> assertThat(personDto.getFoo()).isEqualTo("not ignored")
        );
    }


    @Test
    void toPerson() {

        final SimplePersonDto person = SimplePersonDto.builder()
            .givenname("Max")
            .surname("Mustermann")
            .foo("will be ignored")
            .build();

        final SimplePersonEntity personDto = personMapper.toPerson(person);

        assertAll(
            () -> assertThat(personDto.getFirstname()).isEqualTo("Max"),
            () -> assertThat(personDto.getLastname()).isEqualTo("Mustermann"),
            // because marked as ignored:
            () -> assertThat(personDto.getFoo()).isNull()
        );
    }

}
