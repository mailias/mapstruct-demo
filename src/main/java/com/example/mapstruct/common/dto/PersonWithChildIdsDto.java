package com.example.mapstruct.common.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PersonWithChildIdsDto {
    Long id;
    String givenname;
    String surname;
    List<Long> childrenIds;
}
