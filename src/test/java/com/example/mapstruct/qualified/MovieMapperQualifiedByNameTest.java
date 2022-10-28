package com.example.mapstruct.qualified;

import static org.assertj.core.api.Assertions.assertThat;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class MovieMapperQualifiedByNameTest {

    final MovieMapperQualifiedByName mapper = Mappers.getMapper(MovieMapperQualifiedByName.class);


    @Test
    void toGerman() {
        final OriginalRelease originalRelease = OriginalRelease.builder()
            .title("Hello World!")
            .build();

        final GermanRelease result = mapper.toGerman(originalRelease);

        System.out.println(ReflectionToStringBuilder.toString(result, ToStringStyle.MULTI_LINE_STYLE));

        assertThat(result.getTitle()).isEqualTo("Hallo Welt!");
    }

    @Test
    void toEnglish() {
        final OriginalRelease originalRelease = OriginalRelease.builder()
            .title("Hallo Welt!")
            .build();

        final EnglishRelease result = mapper.toEnglish(originalRelease);

        System.out.println(ReflectionToStringBuilder.toString(result, ToStringStyle.MULTI_LINE_STYLE));

        assertThat(result.getTitle()).isEqualTo("Hello World!");

    }
}
