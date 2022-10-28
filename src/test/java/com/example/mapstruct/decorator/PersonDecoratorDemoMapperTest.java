package com.example.mapstruct.decorator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.mapstruct.factory.Mappers;

/**
 * Mapping customization with decorators
 * https://mapstruct.org/documentation/stable/reference/html/#customizing-mappers-using-decorators
 */
class PersonDecoratorDemoMapperTest {

    final PersonDecoratorDemoMapper mapper = Mappers.getMapper(PersonDecoratorDemoMapper.class);


    @Test
    void toPersonDto1() {

        final UserDto user = UserDto.builder()
            .username("mmustermann")
            .fullname("Mustermann, Max")
            .build();

        final PersonDto result = mapper.toPersonDto(user);

        System.out.println(ReflectionToStringBuilder.toString(result, ToStringStyle.MULTI_LINE_STYLE));

        assertAll(
            () -> assertThat(result.getUsername()).isEqualTo("mmustermann"),
            () -> assertThat(result.getFirstname()).isEqualTo("Max"),
            () -> assertThat(result.getLastname()).isEqualTo("Mustermann")
        );
    }

    @Test
    void toPersonDto2() {

        final UserDto user = UserDto.builder()
            .username("mmustermann")
            .fullname("Mustermann")
            .build();

        final PersonDto result = mapper.toPersonDto(user);

        System.out.println(ReflectionToStringBuilder.toString(result, ToStringStyle.MULTI_LINE_STYLE));

        assertAll(
            () -> assertThat(result.getUsername()).isEqualTo("mmustermann"),
            () -> assertThat(result.getFirstname()).isEqualTo("---"),
            () -> assertThat(result.getLastname()).isEqualTo("Mustermann")
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    void toPersonDto_emptyFullname(final String fullname) {

        final UserDto user = UserDto.builder()
            .username("mmustermann")
            .fullname(fullname)
            .build();

        final PersonDto result = mapper.toPersonDto(user);

        System.out.println(ReflectionToStringBuilder.toString(result, ToStringStyle.MULTI_LINE_STYLE));

        assertAll(
            () -> assertThat(result.getUsername()).isEqualTo("mmustermann"),
            () -> assertThat(result.getFirstname()).isEqualTo("---"),
            () -> assertThat(result.getLastname()).isEqualTo("---")
        );
    }
}
