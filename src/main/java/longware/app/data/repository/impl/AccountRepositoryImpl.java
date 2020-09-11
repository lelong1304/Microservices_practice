package longware.app.data.repository.impl;

import lombok.AllArgsConstructor;
import longware.app.data.entity.AccountEntity;
import longware.app.data.mapper.AccountEntityMapper;
import longware.app.data.repository.AccountEntityRepository;
import longware.app.domain.model.Account;
import longware.app.domain.repository.AccountRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@AllArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {
    private AccountEntityMapper mapper;
    private AccountEntityRepository repository;
    @Override
    public List<Account> findAll() {
        List<AccountEntity> listEntity = repository.findAll();
        List<Account> list = mapper.toAccountList(listEntity);
        return list;
    }

    @Override
    public Account create(Account account) {
        AccountEntity entity = mapper.toAccountEntity(account);
        AccountEntity value = repository.save(entity);
        return mapper.toAccount(value);
    }
}
