package br.ufsm.csi.poow2.giflex.model;

import javax.persistence.*;
import java.util.HashSet;
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

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(
          name = "character_artifact",
          joinColumns = @JoinColumn(name = "character_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "artifact_id", referencedColumnName = "id")
  )

  private Set<Artifact> artifacts = new HashSet<>();

  public Set<Artifact> getArtifacts() {
    return artifacts;
  }

  public void setArtifacts(Set<Artifact> artifacts) {
    this.artifacts = artifacts;
  }

  public Character() {

  }

  public Character(String name, String level, String critRate, String critDmg, Set<Artifact> artifacts) {
    this.name = name;
    this.level = level;
    this.critRate = critRate;
    this.critDmg = critDmg;
    this.artifacts = artifacts;
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

}
