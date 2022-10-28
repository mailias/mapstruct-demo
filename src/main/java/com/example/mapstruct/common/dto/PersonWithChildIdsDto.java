package com.example.mapstruct.common.dto;

import java.util.List;
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
public class PersonWithChildIdsDto {
    Long id;
    String givenname;
    String surname;
    List<Long> childrenIds;
}
