
**[^^^](../README.md)**

# Qualifizierter Mapping-Methoden-Aufruf

## mittels Name
- [Mapper mit Mapping-Methoden-Aufruf durch Name qualifiziert](MovieMapperQualifiedByName.java)
- [Die erzeugte Mapper-Implementierung](MovieMapperQualifiedByNameImpl.java)
- [Test](MovieMapperQualifiedByNameTest.java)


```java
@Mapper(componentModel = "spring")
public abstract class PersonMapper {

    ...
    @Mapping(target = "createTimestamp", source = "createTimestamp", 
        // use custom mapper by name 
	    qualifiedByName = "toLocalDateTime")
    public abstract PersonDTO toPersonDTO(final Person person);


	// the custom mapper
    @Named("toLocalDateTime")
    public static LocalDateTime toLocalDateTime(final Date date) {
        return date != null ? 
	        date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime() : null;
    }

	...
}
```

(!) nicht refactoring-sicher


 
## mittels Annotation
- [Mapper mit Mapping-Methoden-Aufruf durch Annotation qualifiziert](MovieMapperQualifiedByAnnotation.java)
- [Die erzeugte Mapper-Implementierung](MovieMapperQualifiedByAnnotationImpl.java)
- [Test](MovieMapperQualifiedByAnnotationTest.java)

## Doku
- [5.9. Mapping method selection based on qualifiers](https://mapstruct.org/documentation/stable/reference/html/#selection-based-on-qualifiers)
