# MapStruct Demo

[Mapstruct Demo Project](https://github.com/mailias/mapstruct-demo)


## Intro
- [Wozu Mapper?](mapper_wozu.md)
- [Was ist MapStruct?](was_ist_mapstruct.md)
- [Setup](mapstruct_setup.md)
- [Holen der Mapper-Instanz](holen_der_mapper_instanz.md)



## Beispiele

[Einfacher Mapper](src/main/java/com/example/mapstruct/simple_with_inverse/README.md)

[Aktualisieren existierender Bean-Instanzen](src/main/java/com/example/mapstruct/update/README.md)

[Mehrere Quellen](src/main/java/com/example/mapstruct/multiple_sources/README.md)

[Mappen einer Map auf ein Bean](src/main/java/com/example/mapstruct/map_to_bean/README.md)

[Benutzerdefinierte Mapping-Methoden](src/main/java/com/example/mapstruct/custom_methods/README.md)
  - Auflösung anhand von Datentypen

[Aufrufen andere Mapper](src/main/java/com/example/mapstruct/invoking_other_mappers/README.md)

[Qualifizierter Mapping-Methoden-Aufruf](src/main/java/com/example/mapstruct/qualified/README.md)
  - über Name 
  - eigene Annotation

Wiederverwendung von Mapping-Konfigurationen
  - [Doku - Reusing Mapping Configurations](https://mapstruct.org/documentation/stable/reference/html/#_reusing_mapping_configurations)
  - Mit ```@InheritConfiguration``` und ```@InheritInverseConfiguration``` kann man Mappings bei ähnlichen Methoden wiederverwenden.
  - Mit ```@MapperConfig``` können Mappings zur gemeinsamen Verwendung in eine zentrale Klasse ausgelagert werden.



Customizing Mappings: 
- [Customizing Mappings](https://mapstruct.org/documentation/stable/reference/html/#_customizing_mappings)
  - Decorator:
    - [Decorator](src/main/java/com/example/mapstruct/decorator/README.md)
    - [Decorator 2](src/main/java/com/example/mapstruct/decorator2/README.md)
  - @BeforeMapping, @Aftermapping




Beispiel aus Projekt: Setzen von Rückwärtsreferenzen bei One to Many 


Account-Entity soll Liste mit AccountInfos haben, die wiederum eine Referenz auf den Account haben.

```java
@Mapper(componentModel = "spring")
public abstract class AccountMapper {

    public abstract Account toAccount(AccountDTO accountDTO);

    @AfterMapping
    public void afterMappingAccount(@MappingTarget final Account account) {
        setAccountInfosBackreferenceToAccount(account);
    }

    /**
     * Sets the back reference from account infos to the account.
     * (This is necessary because the MapStruct mapper itself does not set these back references
     * but they are required for JPA to work as expected. 
     * Not setting back reference leads to null constraint errors).
     */
    private void setAccountInfosBackreferenceToAccount(final Account account) {
        if (account.getAccountInfos() != null) {
            final Map<String, AccountInfo> accountInfos = new HashMap<>();
            for (final String key : account.getAccountInfos().keySet()) {
                final AccountInfo accountInfo = account.getAccountInfos().get(key);
                accountInfo.setAccount(account);
                accountInfos.put(key, accountInfo);
            }
            account.setAccountInfos(accountInfos);
        }
    }
}
```




## Schluss
- [Best Practices](best_practices.md)



## Dokumentation
- [MapStruct Reference Guide](https://mapstruct.org/documentation/stable/reference/html)
- [tutorialspoint.com/mapstruct](https://www.tutorialspoint.com/mapstruct/index.htm)
- [baeldung.com/mapstruct](https://www.baeldung.com/mapstruct)
- [One-Stop Guide to Mapping with MapStruct - reflectoring.io](https://reflectoring.io/java-mapping-with-mapstruct)
