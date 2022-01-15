package br.ufsm.csi.poow2.giflex.model;

import javax.persistence.*;

@Entity
@Table(name = "character")
public class Character {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int CharacterId;

  @Column(name = "name")
  private String Name;

  @Column(name = "level")
  private String Level;

  @Column(name = "critrate")
  private String CritRate;

  @Column(name = "critdmg")
  private String CritDmg;

  public Character() {

  }

  public Character(int CharacterId) {
    this.CharacterId = CharacterId;
  }

  public Character(String name, String level, String critRate, String critDmg) {
    Name = name;
    Level = level;
    CritRate = critRate;
    CritDmg = critDmg;
  }

  public Character(int characterId, String name, String level, String critRate, String critDmg) {
    CharacterId = characterId;
    Name = name;
    Level = level;
    CritRate = critRate;
    CritDmg = critDmg;
  }

  public int getCharacterId() {
    return CharacterId;
  }

  public void setCharacterId(int characterId) {
    this.CharacterId = characterId;
  }


  public String getName() {
    return Name;
  }

  public void setName(String name) {
    this.Name = name;
  }


  public String getLevel() {
    return Level;
  }

  public void setLevel(String level) {
    this.Level = level;
  }


  public String getCritRate() {
    return CritRate;
  }

  public void setCritRate(String critRate) {
    this.CritRate = critRate;
  }


  public String getCritDmg() {
    return CritDmg;
  }

  public void setCritDmg(String critDmg) {
    this.CritDmg = critDmg;
  }

}
