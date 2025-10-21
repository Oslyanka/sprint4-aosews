package com.xp.advisor.service.impl;

import com.xp.advisor.entity.Client;
import com.xp.advisor.repository.ClientRepository;
import com.xp.advisor.service.ClientService;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
  private final ClientRepository repo;
  public ClientServiceImpl(ClientRepository repo){ this.repo = repo; }
  public Client create(Client c){ return repo.save(c); }
  public Client get(Long id){ return repo.findById(id).orElseThrow(); }
}
