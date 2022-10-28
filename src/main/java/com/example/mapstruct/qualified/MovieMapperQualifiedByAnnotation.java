package com.example.mapstruct.qualified;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Qualifier;

@Mapper(uses = MovieMapperQualifiedByAnnotation.MyTitleTranslator.class)
public interface MovieMapperQualifiedByAnnotation {

    // -----------------------
    // annotations
    // -----------------------
    @Qualifier
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.CLASS)
    @interface TitleTranslator {

    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    @interface EnglishToGerman {

    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    @interface GermanToEnglish {

    }

    // -----------------------
    // title translator
    // -----------------------

    @TitleTranslator
    class MyTitleTranslator {

        @EnglishToGerman
        public String translateTitleEG(String title) {
            return title.replace("Hello", "Hallo").replace("World", "Welt");
        }

        @GermanToEnglish
        public String translateTitleGE(String title) {
            return title.replace("Hallo", "Hello").replace("Welt", "World");
        }

    }


    // -----------------------
    // mapper methods
    // -----------------------

    @Mapping(target = "title", qualifiedBy = {TitleTranslator.class, EnglishToGerman.class})
    GermanRelease toGerman(OriginalRelease originalRelease);

    @Mapping(target = "title", qualifiedBy = {TitleTranslator.class, GermanToEnglish.class})
    EnglishRelease toEnglish(OriginalRelease originalRelease);



}
