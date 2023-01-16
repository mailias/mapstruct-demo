## Best Practices

### Expressions Language vermeiden

[Doku zu Expressions](https://mapstruct.org/documentation/stable/reference/html/#expressions)

```
@Mapper
public interface SourceTargetMapper {

    SourceTargetMapper INSTANCE = Mappers.getMapper( SourceTargetMapper.class );

    @Mapping(target = "timeAndFormat",
         expression = "java( new org.sample.TimeAndFormat( s.getTime(), s.getFormat() ) )")
    Target sourceToTarget(Source s);
}
```

- funktioniert, aber Expressions sind nicht refactoring-sicher!


### Mappings durch Unit-Tests absichern

- Unit-Test sind immer eine gute Idee :-)

