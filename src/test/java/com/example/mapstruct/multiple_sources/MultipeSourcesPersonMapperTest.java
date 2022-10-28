package com.example.mapstruct.multiple_sources;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.example.mapstruct.common.dto.PersonWithAddressDto;
import com.example.mapstruct.common.entity.AddressEntity;
import com.example.mapstruct.common.entity.SimplePersonEntity;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class MultipeSourcesPersonMapperTest {

    final MultipeSourcesPersonMapper personMapper = Mappers.getMapper(MultipeSourcesPersonMapper.class);


    @Test
    void toDto() {

        final SimplePersonEntity personEntity = SimplePersonEntity.builder()
            .id(123L)
            .firstname("Max")
            .lastname("Mustermann")
            .build();

        final AddressEntity addressEntity = AddressEntity.builder()
            .id(999L)
            .street("Musterstr.")
            .housenumber("123 a")
            .zipcode("12345")
            .city("Musterhausen")
            .build();

        final PersonWithAddressDto result = personMapper.toDto(personEntity, addressEntity);

        assertAll(
            () -> assertThat(result.getId()).isEqualTo(123L),
            () -> assertThat(result.getGivenname()).isEqualTo("Max"),
            () -> assertThat(result.getSurname()).isEqualTo("Mustermann"),
            () -> assertThat(result.getStreet()).isEqualTo("Musterstr."),
            () -> assertThat(result.getHousenumber()).isEqualTo("123 a"),
            () -> assertThat(result.getZipcode()).isEqualTo("12345"),
            () -> assertThat(result.getCity()).isEqualTo("Musterhausen")
        );

        System.out.println(ReflectionToStringBuilder.toString(result, ToStringStyle.MULTI_LINE_STYLE));
    }
}
