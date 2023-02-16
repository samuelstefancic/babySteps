package ajc.formation.alten.finalRest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ajc.formation.alten.finalRest.entity.Account;
import ajc.formation.alten.finalRest.entity.AccountRole;
import ajc.formation.alten.finalRest.service.AccountService;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class AccountTest {
    
    @Autowired
    private AccountService accountService;

    @BeforeAll
    void create() {
        Account account = new Account();
        account.setLogin("UserTest101");
        account.setRawPassword("UserTest101");
        accountService.createAccount(account, AccountRole.ROLE_ADMIN);
    }

    @Test
    void createTest() {
        assertNotNull(accountService.getByLogin("UserTest101"));
    }

/* 
    @AfterAll
    void delete() {
        Account accountInDB = accountService.getByLogin("UserTest101");
        accountService.deleteByIdLogin(accountInDB.getIdAccount());
        assertFalse(accountService.loginExist("UserTest101"));
    }
*/
}
