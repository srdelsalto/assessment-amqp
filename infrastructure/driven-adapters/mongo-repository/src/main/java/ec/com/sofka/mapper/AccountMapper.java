package ec.com.sofka.mapper;

import ec.com.sofka.Account;
import ec.com.sofka.entities.AccountEntity;

public class AccountMapper {
    public static Account fromEntity(AccountEntity accountEntity){
        return new Account(accountEntity.getId(), accountEntity.getAccountNumber(), accountEntity.getBalance(), accountEntity.getUserId());
    }

    public static AccountEntity toEntity(Account account){
        return new AccountEntity(account.getId(), account.getAccountNumber(), account.getBalance(), account.getUserId());
    }
}