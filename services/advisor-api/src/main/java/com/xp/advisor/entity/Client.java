package com.xp.advisor.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Client {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String riskProfile;
  private BigDecimal liquidity;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getName() { return name; }
  public void setName(String name) { this.name = name; }
  public String getRiskProfile() { return riskProfile; }
  public void setRiskProfile(String riskProfile) { this.riskProfile = riskProfile; }
  public BigDecimal getLiquidity() { return liquidity; }
  public void setLiquidity(BigDecimal liquidity) { this.liquidity = liquidity; }
}
