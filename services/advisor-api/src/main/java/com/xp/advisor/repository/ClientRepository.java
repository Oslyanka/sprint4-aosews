package com.xp.advisor.repository;

import com.xp.advisor.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> { }
