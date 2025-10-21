package com.xp.advisor.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Asset {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String ticker;
  private String assetClass;
  private BigDecimal risk;
  private BigDecimal expReturn;

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getTicker() { return ticker; }
  public void setTicker(String ticker) { this.ticker = ticker; }
  public String getAssetClass() { return assetClass; }
  public void setAssetClass(String assetClass) { this.assetClass = assetClass; }
  public BigDecimal getRisk() { return risk; }
  public void setRisk(BigDecimal risk) { this.risk = risk; }
  public BigDecimal getExpReturn() { return expReturn; }
  public void setExpReturn(BigDecimal expReturn) { this.expReturn = expReturn; }
}
