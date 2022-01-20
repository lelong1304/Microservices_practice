package longware.app.web.rest;

import lombok.AllArgsConstructor;
import longware.app.domain.model.Account;
import longware.app.domain.service.AccountService;
import longware.app.web.dto.AccountDto;
import longware.app.web.mapper.AccountDtoMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/account")
@CrossOrigin(origins = {"http://localhost:4200"})
public class AccountResource {
    AccountService service;
    AccountDtoMapper mapper;

    @GetMapping
    public Object getAll() {
        List<Account> list = service.getAllAccount();
        return list;
    }

    @PostMapping("/create")
    public Object create(@RequestBody AccountDto dto) {
        Account account = mapper.toAccount(dto);
        return service.createAccount(account);
    }
}
// headers: Origin, Content-Type, Accept, Authorization, Access-Control-Request-Headers
//credentials: true
//origin: http://localhost:4200
