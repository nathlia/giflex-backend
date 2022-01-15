package br.ufsm.csi.poow2.giflex.model;

import javax.persistence.*;

@Entity
@Table(name = "substat")
public class Substat {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int SubstatId;

  @Column(name = "name")
  private String Name;

  @Column(name = "value")
  private double Value;

  public Substat() {
  }

  public Substat(int substatId) {
    SubstatId = substatId;
  }
  public Substat( String name) {
    Name = name;
  }

  public Substat(int substatId, String name) {
    SubstatId = substatId;
    Name = name;
  }

  public int getSubstatId() {
    return SubstatId;
  }

  public void setSubstatId(int substatId) {
    this.SubstatId = substatId;
  }


  public String getName() {
    return Name;
  }

  public void setName(String name) {
    this.Name = name;
  }

  public double getValue() {
    return Value;
  }

  public void setValue(double value) {
    Value = value;
  }
}
