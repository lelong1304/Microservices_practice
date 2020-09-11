package longware.app.domain.service.impl;

import lombok.AllArgsConstructor;
import longware.app.domain.model.Account;
import longware.app.domain.repository.AccountRepository;
import longware.app.domain.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    AccountRepository repository;
    @Override
    public List<Account> getAllAccount() {
        return repository.findAll();
    }

    @Override
    public Account createAccount(Account account) {
        return repository.create(account);
    }
}
