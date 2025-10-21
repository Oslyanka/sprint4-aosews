package com.xp.advisor.repository;

import com.xp.advisor.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserAccount, Long> {
  Optional<UserAccount> findByEmail(String email);
}
