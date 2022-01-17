package br.ufsm.csi.poow2.giflex.model;

import javax.persistence.*;

@Entity
@Table(name = "substat")
public class Substat {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int substatId;

  @Column(name = "name")
  private String name;

  @Column(name = "value")
  private double value;

  public Substat() {
  }

  public Substat(int substatId) {
    this.substatId = substatId;
  }
  public Substat( String name, Double value) {
    this.name = name;
    this.value = value;
  }

  public Substat(int substatId, String name) {
    this.substatId = substatId;
    this.name = name;
  }

  public int getSubstatId() {
    return substatId;
  }

  public void setSubstatId(int substatId) {
    this.substatId = substatId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getValue() {
    return value;
  }

  public void setValue(double value) {
    this.value = value;
  }
}
