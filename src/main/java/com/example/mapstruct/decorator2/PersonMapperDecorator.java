package com.example.mapstruct.decorator2;

public abstract class PersonMapperDecorator implements PersonDecoratorDemoMapper {

    private final PersonDecoratorDemoMapper delegate;

    public PersonMapperDecorator(PersonDecoratorDemoMapper delegate) {
        this.delegate = delegate;
    }

    @Override
    public Person toPerson(PersonDto personDto) {
        final Person person = delegate.toPerson(personDto);
        for(Account account : person.getAccounts()) {
            account.setPerson(person);
        }
        return person;
    }

    @Override
    public PersonDto toPersonDto(Person person) {
        final PersonDto personDto = delegate.toPersonDto(person);
        for(AccountDto accountDto : personDto.getAccounts()) {
            accountDto.setPerson(personDto);
        }
        return personDto;
    }
}
