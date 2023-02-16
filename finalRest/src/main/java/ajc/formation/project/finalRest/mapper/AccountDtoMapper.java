package ajc.formation.alten.finalRest.mapper;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import ajc.formation.alten.finalRest.dto.AccountDto;
import ajc.formation.alten.finalRest.entity.Account;

@Service
public class AccountDtoMapper implements Function<Account, AccountDto>{

    @Override
    public AccountDto apply(Account account) {
        return new AccountDto(
            account.getIdAccount(),
            account.getLogin(),
            account.getAccountRole()
        );
    }
}
