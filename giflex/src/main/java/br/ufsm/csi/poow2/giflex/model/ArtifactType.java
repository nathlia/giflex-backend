package br.ufsm.csi.poow2.giflex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "artifacttype")
public class ArtifactType {

  @Id
  private int id;

  @Column(name = "name")
  private String name;


  @OneToMany(mappedBy = "artifactType")
  @JsonIgnore
  private Set<Artifact> artifacts;

  public ArtifactType() {
  }

  public ArtifactType(int id) {
    this.id = id;
  }

  public ArtifactType( String name) {
    this.name = name;
  }

  public ArtifactType(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int artifactTypeId) {
    this.id = artifactTypeId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @JsonIgnore
  public Set<Artifact> getArtifact() {
    return this.artifacts;
  }
}
