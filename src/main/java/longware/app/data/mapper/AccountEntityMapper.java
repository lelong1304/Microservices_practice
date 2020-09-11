package longware.app.data.mapper;

import longware.app.data.entity.AccountEntity;
import longware.app.domain.model.Account;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface AccountEntityMapper {
    Account toAccount(AccountEntity entity);

    AccountEntity toAccountEntity(Account account);

    List<Account> toAccountList(List<AccountEntity> list);
}
