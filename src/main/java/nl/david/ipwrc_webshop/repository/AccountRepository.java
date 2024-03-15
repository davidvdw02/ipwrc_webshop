package nl.david.ipwrc_webshop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import nl.david.ipwrc_webshop.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
    Optional<Account> findByUsername(String username);
}
