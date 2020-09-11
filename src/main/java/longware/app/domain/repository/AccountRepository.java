package longware.app.domain.repository;

import longware.app.domain.model.Account;

import java.util.List;

public interface AccountRepository {
    List<Account> findAll();
    Account create(Account account);
}
