package br.ufsm.csi.poow2.giflex.model;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "character")
public class Character {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "level")
  private String level;

  @Column(name = "critrate")
  private String critRate;

  @Column(name = "critdmg")
  private String critDmg;

//  @ManyToMany(mappedBy = "addedCharacters")
//  @JoinTable(
//          name = "usercharacter",
//          joinColumns = @JoinColumn(name = "playerid", referencedColumnName = "id"),
//          inverseJoinColumns = @JoinColumn(name = "characterid", referencedColumnName = "id")
//  )

//  private Set<Player> players = new HashSet<>();

  public Character() {

  }

  public Character(int id) {
    this.id = id;
  }

  public Character(String name, String level, String critRate, String critDmg) {
    this.name = name;
    this.level = level;
    this.critRate = critRate;
    this.critDmg = critDmg;
  }

  public Character(int id, String name, String level, String critRate, String critDmg) {
    this.id = id;
    this.name = name;
    this.level = level;
    this.critRate = critRate;
    this.critDmg = critDmg;
  }

  public int getId() {
    return id;
  }

  public void setId(int characterId) {
    this.id = characterId;
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

//  public Set<Player> getCharacters() {
//    return players;
//  }
//
//  public void setCharacters(Set<Player> characters) {
//    this.players = characters;
//  }
}
