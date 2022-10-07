package com.example.demo.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.example.demo.dto.PersonDto;
import com.example.demo.entity.Person;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class PersonMapperTest {

    PersonMapper personMapper = Mappers.getMapper(PersonMapper.class);

    @Test
    void toPersonDto() {

        Person person = new Person();
        person.setFirstname("Max");
        person.setLastname("Mustermann");
        PersonDto personDto = personMapper.toPersonDto(person);

        assertAll(
            () -> assertThat(personDto.getGivenname()).isEqualTo("Max"),
            () -> assertThat(personDto.getSurname()).isEqualTo("Mustermann")
        );
    }
}
