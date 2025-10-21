package com.xp.advisor.service;

import com.xp.advisor.entity.Client;

public interface ClientService {
  Client create(Client c);
  Client get(Long id);
}
