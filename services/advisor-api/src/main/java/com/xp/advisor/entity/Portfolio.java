package com.xp.advisor.entity;

import jakarta.persistence.*;
import java.util.*;
import java.math.BigDecimal;

@Entity
public class Portfolio {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long clientId;

  @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Position> positions = new ArrayList<>();

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public Long getClientId() { return clientId; }
  public void setClientId(Long clientId) { this.clientId = clientId; }
  public List<Position> getPositions() { return positions; }
  public void setPositions(List<Position> positions) { this.positions = positions; }
}
