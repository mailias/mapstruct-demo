package com.example.mapstruct.simple_with_inverse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.example.mapstruct.common.dto.SimplePersonDto;
import com.example.mapstruct.common.entity.SimplePersonEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Als {@link SpringBootTest} um Spring Injection des Mappers zu testen.
 * Normalerweise würde man für einen Mapper-Test eher einen normalen Unit-Test verwenden,
 * siehe {@link SimplePersonMapperWithInverse1Test}.
 */
@SpringBootTest
class SimplePersonMapperSpringBootTest {

    @Autowired
    SimplePersonMapperWithInverse1 personMapper;

    @Test
    void toPersonDto() {

        final SimplePersonEntity person = new SimplePersonEntity();
        person.setFirstname("Max");
        person.setLastname("Mustermann");
        final SimplePersonDto personDto = personMapper.toPersonDto(person);

        assertAll(
            () -> assertThat(personDto.getGivenname()).isEqualTo("Max"),
            () -> assertThat(personDto.getSurname()).isEqualTo("Mustermann")
        );
    }
}
