package br.ufsm.csi.poow2.giflex.model;

import javax.persistence.*;

@Entity
@Table(name = "character")
public class Character {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long characterId;

  @Column(name = "name")
  private String name;

  @Column(name = "level")
  private String level;

  @Column(name = "critrate")
  private String critRate;

  @Column(name = "critdmg")
  private String critDmg;

  public Character() {

  }

  public Character(Long CharacterId) {
    this.characterId = CharacterId;
  }

  public Character(String name, String level, String critRate, String critDmg) {
    this.name = name;
    this.level = level;
    this.critRate = critRate;
    this.critDmg = critDmg;
  }

  public Character(Long characterId, String name, String level, String critRate, String critDmg) {
    this.characterId = characterId;
    this.name = name;
    this.level = level;
    this.critRate = critRate;
    this.critDmg = critDmg;
  }

  public Long getCharacterId() {
    return characterId;
  }

  public void setCharacterId(Long characterId) {
    this.characterId = characterId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }


  public String getCritRate() {
    return critRate;
  }

  public void setCritRate(String critRate) {
    this.critRate = critRate;
  }


  public String getCritDmg() {
    return critDmg;
  }

  public void setCritDmg(String critDmg) {
    this.critDmg = critDmg;
  }

}
