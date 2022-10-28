package com.example.mapstruct.update;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.example.mapstruct.common.dto.SimplePersonDto;
import com.example.mapstruct.common.entity.SimplePersonEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class PersonMapperWithUpdateTest {

    final PersonMapperWithUpdate personMapper = Mappers.getMapper(PersonMapperWithUpdate.class);


    @Test
    void updatePersonFromPersonDto() {

        final SimplePersonDto personDto = SimplePersonDto.builder()
            .givenname("Martina")
            .surname("Maier")
            .build();

        final SimplePersonEntity personEntity = SimplePersonEntity.builder()
            .firstname("Martina")
            .lastname("Mustermann")
            .build();

        final SimplePersonEntity result = personMapper.updatePersonFromPersonDto(personDto, personEntity);

        assertAll(
            () -> assertThat(personEntity.getFirstname()).isEqualTo("Martina"),
            () -> assertThat(personEntity.getLastname()).isEqualTo("Maier"),

            () -> assertThat(result.getFirstname()).isEqualTo("Martina"),
            () -> assertThat(result.getLastname()).isEqualTo("Maier")
        );
    }

}
