package com.example.mapstruct.common.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
public class PersonWithAddressEntity {

    @Id
    Long id;

    String firstname;
    String lastname;

    @OneToMany
    List<PersonWithAddressEntity> children;

    @OneToOne
    @JoinColumn(name = "address_id")
    AddressEntity address;

}
