package com.example.mapstruct.map_to_bean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.example.mapstruct.common.dto.PersonWithAddressDto;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class MapToPersonMapperTest {

    final MapToPersonMapper personMapper = Mappers.getMapper(MapToPersonMapper.class);


    @Test
    void toDto() {

        final Map<String, String> map = new HashMap<>();
        map.put("id", "123");
        map.put("firstname", "Max");
        map.put("lastname", "Mustermann");
        map.put("street", "Musterstr.");
        map.put("housenumber", "123 a");
        map.put("zipcode", "12345");
        map.put("city", "Musterhausen");

        final PersonWithAddressDto result = personMapper.toDto(map);

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
