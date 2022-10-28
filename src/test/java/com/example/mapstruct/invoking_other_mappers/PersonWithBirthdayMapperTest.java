package com.example.mapstruct.invoking_other_mappers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.example.mapstruct.common.dto.PersonWithBirthdayDto;
import com.example.mapstruct.common.entity.PersonWithBirthdayEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class PersonWithBirthdayMapperTest {

    final PersonWithBirthdayMapper personMapper = Mappers.getMapper(PersonWithBirthdayMapper.class);


    @Test
    void toPersonDto() throws ParseException {

        final PersonWithBirthdayEntity person = PersonWithBirthdayEntity.builder()
            .firstname("Max")
            .lastname("Mustermann")
            .birthday(new SimpleDateFormat("dd.MM.yyyy").parse("30.10.1980"))
            .build();

        final PersonWithBirthdayDto result = personMapper.toPersonDto(person);

        System.out.println(ReflectionToStringBuilder.toString(result, ToStringStyle.MULTI_LINE_STYLE));

        assertAll(
            () -> assertThat(result.getGivenname()).isEqualTo("Max"),
            () -> assertThat(result.getSurname()).isEqualTo("Mustermann"),
            () -> assertThat(result.getBirthday()).isEqualTo("1980-10-30")
        );
    }


    @Test
    void toPerson() {

        final PersonWithBirthdayDto personDto = PersonWithBirthdayDto.builder()
            .givenname("Max")
            .surname("Mustermann")
            .birthday("1980-10-30")
            .build();

        final PersonWithBirthdayEntity result = personMapper.toPerson(personDto);

        System.out.println(ReflectionToStringBuilder.toString(result, ToStringStyle.MULTI_LINE_STYLE));

        assertAll(
            () -> assertThat(result.getFirstname()).isEqualTo("Max"),
            () -> assertThat(result.getLastname()).isEqualTo("Mustermann"),
            () -> assertThat(result.getBirthday())
                .isEqualTo(new SimpleDateFormat("dd.MM.yyyy").parse("30.10.1980"))
        );
    }
}
