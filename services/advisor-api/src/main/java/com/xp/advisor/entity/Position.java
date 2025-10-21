package com.xp.advisor.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Position {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  private Portfolio portfolio;

  @ManyToOne
  private Asset asset;

  private BigDecimal weight;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public Portfolio getPortfolio() { return portfolio; }
  public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
  public Asset getAsset() { return asset; }
  public void setAsset(Asset asset) { this.asset = asset; }
  public BigDecimal getWeight() { return weight; }
  public void setWeight(BigDecimal weight) { this.weight = weight; }
}
