package br.ufsm.csi.poow2.giflex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "artifactsettype")
public class ArtifactSetType {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "name")
  private String name;

  @Column(name = "twopieces")
  private String twopieces;

  @Column(name = "fourpieces")
  private String fourpieces;

  @OneToMany(mappedBy = "artifactSetType")
  @JsonIgnore
  private Set<Artifact> artifacts;

  public ArtifactSetType() {

  }

  public ArtifactSetType(int id) {
    this.id = id;
  }

  public ArtifactSetType(String name, String twopieces, String fourpieces) {
    this.name = name;
    this.twopieces = twopieces;
    this.fourpieces = fourpieces;
  }

  public ArtifactSetType(int id, String name, String twopieces, String fourpieces) {
    this.id = id;
    this.name = name;
    this.twopieces = twopieces;
    this.fourpieces = fourpieces;
  }

  public int getId() {
    return id;
  }

  public void setId(int artifactSetTypeId) {
    this.id = artifactSetTypeId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTwopieces() {
    return twopieces;
  }

  public void setTwopieces(String twopieces) {
    this.twopieces = twopieces;
  }

  public String getFourpieces() {
    return fourpieces;
  }

  public void setFourpieces(String fourpieces) {
    this.fourpieces = fourpieces;
  }

  @JsonIgnore
  public Set<Artifact> getArtifacts() {
    return artifacts;
  }

  @JsonIgnore
  public void setArtifacts(Set<Artifact> artifacts) {
    this.artifacts = artifacts;
  }
}
