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

//  @OneToOne(orphanRemoval = true)
//  @JoinTable(name = "character_filedb",
//          joinColumns = @JoinColumn(name = "character_id", referencedColumnName = "id"),
//          inverseJoinColumns = @JoinColumn(name = "filedb_id", referencedColumnName = "id"))
//  private FileDB fileDB;
//
//
//  public FileDB getFileDB() {
//    return fileDB;
//  }
//
//  public void setFileDB(FileDB fileDB) {
//    this.fileDB = fileDB;
//  }

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(
          name = "character_artifact",
          joinColumns = @JoinColumn(name = "character_id", referencedColumnName = "id"),
          inverseJoinColumns = @JoinColumn(name = "artifact_id", referencedColumnName = "id")
  )
  private Set<Artifact> equippedArtifacts = new HashSet<>();

  public Character() {

  }

  public Character(String name, String level, String critRate, String critDmg) {
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

  public Set<Artifact> getEquippedArtifacts() {
    return equippedArtifacts;
  }

  public void setEquippedArtifacts(Set<Artifact> equippedArtifacts) {
    this.equippedArtifacts = equippedArtifacts;
  }
}
