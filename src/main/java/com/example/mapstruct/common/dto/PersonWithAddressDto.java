package com.example.mapstruct.common.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonWithAddressDto {
    Long id;
    String givenname;
    String surname;

    String street;
    String housenumber;
    String zipcode;
    String city;

}
