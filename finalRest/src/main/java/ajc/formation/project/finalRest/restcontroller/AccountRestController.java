package ajc.formation.alten.finalRest.restcontroller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import ajc.formation.alten.finalRest.dto.AccountDto;
import ajc.formation.alten.finalRest.entity.Account;
import ajc.formation.alten.finalRest.entity.AccountRole;
import ajc.formation.alten.finalRest.exception.AccountException;
import ajc.formation.alten.finalRest.jsonview.Views;
import ajc.formation.alten.finalRest.mapper.AccountDtoMapper;
import ajc.formation.alten.finalRest.service.AccountService;
import ajc.formation.alten.finalRest.util.CheckBindingResult;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/account")
@CrossOrigin(origins = "*")
public class AccountRestController {
    
    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountDtoMapper accountDtoMapper;

    @GetMapping("")
    @JsonView(Views.Common.class)
    public List<AccountDto> getAll() {
        return accountService.getAll()
            .stream()
            .map(accountDtoMapper)
            .collect(Collectors.toList());
    }

    @GetMapping("/page/{pageNumber}/{itemPerPage}")
    @JsonView(Views.Common.class)
    public List<AccountDto> getAllPage(@PathVariable int pageNumber, @PathVariable int itemPerPage) {
        if (pageNumber < 0 || pageNumber > accountService.getAll(PageRequest.ofSize(itemPerPage)).getTotalPages()) {
            throw new AccountException("Wrong Page Number");
        }
        return accountService.getAll(PageRequest.of(pageNumber, itemPerPage)).getContent()
            .stream()
            .map(accountDtoMapper)
            .collect(Collectors.toList());
    }

    @GetMapping("/id/{id}")
    @JsonView(Views.Common.class)
    public AccountDto getById(@PathVariable Long id) {
        return accountDtoMapper.apply(accountService.getByIdLogin(id));
    }

    @GetMapping("/login/{login}")
    @JsonView(Views.Common.class)
    public AccountDto getByLogin(@PathVariable String login) {
        return accountDtoMapper.apply(accountService.getByLogin(login));
    }

    @PostMapping("")
    @JsonView(Views.Common.class)
    public AccountDto createUser(@Valid @RequestBody Account account, BindingResult bindingResult) {
        CheckBindingResult.checkBindingResulHasError(bindingResult);
        return accountDtoMapper.apply(accountService.createAccount(account, AccountRole.ROLE_USER));
    }

    @DeleteMapping("/id/{id}")
    public void deleteById(@PathVariable Long id) {
        accountService.deleteByIdLogin(id);
    }

    @DeleteMapping("/login/{login}")
    public void deleteByLogin(@PathVariable String login) {
        accountService.deleteByLogin(login);
    }
    
	@GetMapping("/checklogin/{login}")
	public boolean checkLoginExist(@PathVariable String login) {
		return accountService.loginExist(login);
	}
}
