package com.example.mapstruct.common.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonWithBirthdayEntity {

    @Id
    Long id;

    String firstname;
    String lastname;

    Date birthday;
    
}
