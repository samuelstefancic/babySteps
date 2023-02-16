package ajc.formation.alten.finalRest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ajc.formation.alten.finalRest.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
    
    Optional<Account> findByLogin(String login);
}
