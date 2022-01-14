package br.ufsm.csi.poow2.giflex.model;

public class Substat {

  private int SubstatId;
  private String Name;
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
