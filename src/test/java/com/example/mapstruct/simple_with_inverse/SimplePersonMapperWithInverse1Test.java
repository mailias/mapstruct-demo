package com.example.mapstruct.simple_with_inverse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.example.mapstruct.common.dto.SimplePersonDto;
import com.example.mapstruct.common.entity.SimplePersonEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class SimplePersonMapperWithInverse1Test {

    final SimplePersonMapperWithInverse1 personMapper = Mappers.getMapper(SimplePersonMapperWithInverse1.class);

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

        final SimplePersonDto personDto = SimplePersonDto.builder()
            .givenname("Max")
            .surname("Mustermann")
            .foo("will be ignored")
            .build();

        final SimplePersonEntity person = personMapper.toPerson(personDto);

        assertAll(
            () -> assertThat(person.getFirstname()).isEqualTo("Max"),
            () -> assertThat(person.getLastname()).isEqualTo("Mustermann"),
            // because marked as ignored:
            () -> assertThat(person.getFoo()).isNull()
        );
    }

}
