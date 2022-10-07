package com.example.demo.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.example.demo.dto.PersonDto;
import com.example.demo.entity.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Als {@link SpringBootTest} um Spring Injection des Mappers zu testen.
 * Normalerweise würde man für einen Mapper-Test eher einen normalen Unit-Test verwenden,
 * siehe {@link PersonMapperTest}.
 */
@SpringBootTest
class PersonMapperSpringBootTest {

    @Autowired
    PersonMapper personMapper;

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
