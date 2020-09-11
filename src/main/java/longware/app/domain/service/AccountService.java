package longware.app.domain.service;

import longware.app.domain.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccount();
    Account createAccount(Account account);
}
