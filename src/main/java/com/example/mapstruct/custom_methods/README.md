
**[^^^](../README.md)**

# Benutzerdefinierte Mapping-Methoden

- [Mapper](PersonWithChildrenMapper.java)
- [Die erzeugte Mapper-Implementierung](PersonWithChildrenMapperImpl.java)
- [Test](PersonWithChildrenMapperTest.java)


Anderes Beispiel aus Projekt:
Ziel-DTO soll von Passworthistorie nur den letzten Eintrag haben.

```java
@Mapper(componentModel = "spring")
public abstract class AccountMapper {
	
	@Mapping(target = "lastPasswordHistory", source = "account.passwordHistoryEntries")
    public abstract AccountDTO toAccountDTOFromAccount(final Account account);

	public PasswordHistoryDTO mapToLastPasswordHistoryDTO(final List<PasswordHistory> passwordHistoryList) {
        final PasswordHistoryDTO lastPasswordHistory = new PasswordHistoryDTO();
        if (!passwordHistoryList.isEmpty()) {
            final PasswordHistory passwordHistory = passwordHistoryList.get(0);
            lastPasswordHistory.setCreationDate(passwordHistory.getCreationDate());
            lastPasswordHistory.setExpirationDate(passwordHistory.getExpirationDate());
            lastPasswordHistory.setCreationUser(passwordHistory.getCreationUser());
        }
        return lastPasswordHistory;
    }

}
```

(alternativ auch als Interface durch Verwendung von Default-Methode möglich)

note: Erklärung:
- ```toAccountDTOFromAccount``` mappt alles normal,
- könnte auch weitere ```@Mapping```s drüber haben,
- aber aus der Passworthistorie wollen wir nur den letzten Eintrag:
- ```@Mapping(target = "lastPasswordHistory", source = "account.passwordHistoryEntries")```. 
  Kann so aber noch nicht konvertiert werden, da nicht klar ist, wie aus der Liste ein einzelnes DTO werden soll.
- Die Methode ```mapToLastPasswordHistoryDTO``` liefert dazu dann die Implementierung, 
  um von ```List<PasswordHistory>``` nach ```PasswordHistoryDTO``` zu konvertieren



## Doku
- [3.3. Adding custom methods to mappers](https://mapstruct.org/documentation/stable/reference/html/#adding-custom-methods)




