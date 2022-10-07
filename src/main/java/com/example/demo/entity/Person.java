package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person {

    @Id
    Long id;

    String firstname;
    String lastname;

    @OneToMany
    List<Person> children;

}
