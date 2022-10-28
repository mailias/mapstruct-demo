package com.example.mapstruct.decorator;

import org.apache.commons.lang3.StringUtils;

public abstract class PersonMapperDecorator implements PersonDecoratorDemoMapper {

    private final PersonDecoratorDemoMapper delegate;

    public PersonMapperDecorator(PersonDecoratorDemoMapper delegate) {
        this.delegate = delegate;
    }

    @Override
    public PersonDto toPersonDto(final UserDto user) {

        final PersonDto dto = delegate.toPersonDto(user);

        if (StringUtils.isNotBlank(user.getFullname())) {

            final String[] fullnameSplitted = user.getFullname().split(",");
            final String lastname = fullnameSplitted[0].trim();

            if (fullnameSplitted.length == 1) {
                dto.setLastname(lastname);
                dto.setFirstname("---");
            } else {
                dto.setLastname(lastname);
                dto.setFirstname(fullnameSplitted[1].trim());
            }

        } else {
            dto.setLastname("---");
            dto.setFirstname("---");
        }

        return dto;
    }
}
