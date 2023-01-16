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

        final SimplePersonDto sourceDto = SimplePersonDto.builder()
            .givenname("Martina")
            .surname("Maier")
            .build();

        final SimplePersonEntity entityToUpdate = SimplePersonEntity.builder()
            .firstname("Martina")
            .lastname("Mustermann")
            .build();

        personMapper.updatePersonFromPersonDto(sourceDto, entityToUpdate);

        assertAll(
            () -> assertThat(entityToUpdate.getFirstname()).isEqualTo("Martina"),
            () -> assertThat(entityToUpdate.getLastname()).isEqualTo("Maier")
        );
    }

}
