package com.example.demo.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonDto {
    Long id;
    String givenname;
    String surname;
    List<Long> childrenIds;

}
