package com.example.mapstruct.qualified;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.Named;

@Mapper(componentModel = ComponentModel.SPRING)
public interface MovieMapperQualifiedByName {

    @Named("EnglishToGerman")
    default String translateTitleEG(String title) {
        return title
            .replace("Hello", "Hallo")
            .replace("World", "Welt");
    }

    @Named("GermanToEnglish")
    default String translateTitleGE(String title) {
        return title
            .replace("Hallo", "Hello")
            .replace("Welt", "World");
    }

    @Mapping( target = "title", qualifiedByName = { "EnglishToGerman" } )
    GermanRelease toGerman(OriginalRelease originalRelease);

    @Mapping( target = "title", qualifiedByName = { "GermanToEnglish" } )
    EnglishRelease toEnglish(OriginalRelease originalRelease);

}
