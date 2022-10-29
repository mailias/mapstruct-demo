package com.example.mapstruct.decorator2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

class PersonDecoratorDemoMapperTest {

    final PersonDecoratorDemoMapper mapper = Mappers.getMapper(PersonDecoratorDemoMapper.class);

    @Test
    void test() {
        final PersonDto personDto = PersonDto.builder()
            .firstname("Martina")
            .lastname("Musterfrau")
            .accounts(List.of(
                AccountDto.builder()
                    .id(1L)
                    .username("m.musterfrau")
                    .build(),
                AccountDto.builder()
                    .id(2L)
                    .username("m.musterfrau123")
                    .build()
            ))
            .build();

        final Person person = mapper.toPerson(personDto);

        assertThat(person.getAccounts().stream().map(Account::getPerson)).allMatch(
            p -> p == person);

    }


    @Test
    void test2() {
        final Person person = Person.builder()
            .firstname("Martina")
            .lastname("Musterfrau")
            .accounts(List.of(
                Account.builder()
                    .id(1L)
                    .username("m.musterfrau")
                    .build(),
                Account.builder()
                    .id(2L)
                    .username("m.musterfrau123")
                    .build()
            ))
            .build();

        final PersonDto personDto = mapper.toPersonDto(person);

        assertThat(personDto.getAccounts().stream().map(AccountDto::getPerson)).allMatch(
            p -> p == personDto);

    }

}
