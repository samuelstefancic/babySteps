package ajc.formation.alten.finalRest.service;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ajc.formation.alten.finalRest.entity.Account;
import ajc.formation.alten.finalRest.entity.AccountRole;
import ajc.formation.alten.finalRest.exception.AccountException;
import ajc.formation.alten.finalRest.repository.AccountRepository;
import ajc.formation.alten.finalRest.util.CheckId;
import ajc.formation.alten.finalRest.util.CheckPageable;
import ajc.formation.alten.finalRest.util.CheckString;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@Service
public class AccountService implements UserDetailsService{
    
    @Autowired
    private Validator validator;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

    // Create
    public Account createAccount(Account account, AccountRole accountRole) {
        checkAccountIsNotNull(account);
        checkConstraintViolationIsEmpty(validator.validate(account));
        account.setAccountRole(accountRole);
        account.setPassword(passwordEncoder.encode(account.getRawPassword()));
        return accountRepository.save(account);
    }

    // Read
    public Account getByLogin(String login) {
        CheckString.checkStringIsNotNullNorEmpty(login);
        return accountRepository.findByLogin(login).orElseThrow(() -> {
            throw new AccountException("Account not found");
        });
    }

    public Account getByIdLogin(Long idLogin) {
        CheckId.CheckIdIsNotNull(idLogin);
        return accountRepository.findById(idLogin).orElseThrow(() -> {
            throw new AccountException("Account not found");
        });
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public Page<Account> getAll(Pageable pageable) {
        CheckPageable.checkPageableIsNotNull(pageable);
        return accountRepository.findAll(pageable);
    }

    public boolean loginExist(String login) {
        CheckString.checkStringIsNotNullNorEmpty(login);
        return accountRepository.findByLogin(login).isPresent();
    }

    // Delete
    public void deleteByLogin(String login) {
        CheckString.checkStringIsNotNullNorEmpty(login);
        accountRepository.delete(accountRepository.findByLogin(login).orElseThrow(() -> {
            throw new AccountException("Login not found");
        }));
    }

    public void deleteByIdLogin(Long idLogin) {
        CheckId.CheckIdIsNotNull(idLogin);
        accountRepository.deleteById(idLogin);;
    }

    // Check
    private void checkConstraintViolationIsEmpty(Set<ConstraintViolation<Account>> violations) {
        if (!violations.isEmpty()) {
            violations.forEach(v -> {
                LOGGER.debug(v.toString());
            });
            throw new AccountException("Account ConstraintViolation");
        }
    }

    private void checkAccountIsNotNull(Account account) {
        if (account == null) {
            throw new AccountException("Account null");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getByLogin(username);
    }
}
