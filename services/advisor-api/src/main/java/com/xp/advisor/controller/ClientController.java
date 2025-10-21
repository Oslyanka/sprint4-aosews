package com.xp.advisor.controller;

import com.xp.advisor.entity.Client;
import com.xp.advisor.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
  private final ClientService service;
  public ClientController(ClientService service){ this.service = service; }

  @PostMapping
  public ResponseEntity<Client> create(@RequestBody Client c){
    return ResponseEntity.ok(service.create(c));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Client> get(@PathVariable Long id){
    return ResponseEntity.ok(service.get(id));
  }
}
