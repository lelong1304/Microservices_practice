package longware.app.web.mapper;

import longware.app.domain.model.Account;
import longware.app.web.dto.AccountDto;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountDtoMapper {
    Account toAccount(AccountDto dto);

    AccountDto toAccountDto(Account account);

    List<Account> toAccountList(List<AccountDto> list);
}
