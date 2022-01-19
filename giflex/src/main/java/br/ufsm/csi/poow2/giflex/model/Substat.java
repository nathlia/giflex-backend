package br.ufsm.csi.poow2.giflex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "substat")
public class Substat {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "name")
  private String name;

  private Double value;

  @OneToMany(mappedBy = "mainstat")
  @JsonIgnore
  private Set<Artifact> artifacts;

  @ManyToMany(mappedBy = "substats")
  @JsonIgnore
  private Set<Artifact> artifactSubstats;

  public Substat() {
  }

  public Substat(String name, Double value, Set<Artifact> artifacts, Set<Artifact> artifactSubstats) {
    this.name = name;
    this.value = value;
    this.artifacts = artifacts;
    this.artifactSubstats = artifactSubstats;
  }

  public int getId() {
    return id;
  }

  public void setId(int substatId) {
    this.id = substatId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  @JsonIgnore
  public Set<Artifact> getArtifacts() {
    return artifacts;
  }

  @JsonIgnore
  public void setArtifacts(Set<Artifact> artifacts) {
    this.artifacts = artifacts;
  }

  public Set<Artifact> getArtifactSubstats() {
    return artifactSubstats;
  }

  public void setArtifactSubstats(Set<Artifact> artifactSubstats) {
    this.artifactSubstats = artifactSubstats;
  }
}
