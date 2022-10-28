package com.example.mapstruct.common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonWithAddressDto {
    Long id;
    String givenname;
    String surname;

    String street;
    String housenumber;
    String zipcode;
    String city;

}
