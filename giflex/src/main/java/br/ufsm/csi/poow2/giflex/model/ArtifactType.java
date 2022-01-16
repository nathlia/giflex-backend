package br.ufsm.csi.poow2.giflex.model;

import javax.persistence.*;

@Entity
@Table(name = "artifacttype")
public class ArtifactType {

  @Id
  private int artifactTypeId;

  @Column(name = "name")
  private String name;

  public ArtifactType() {
  }

  public ArtifactType(int artifactTypeId) {
    this.artifactTypeId = artifactTypeId;
  }

  public ArtifactType( String name) {
    this.name = name;
  }

  public ArtifactType(int artifactTypeId, String name) {
    this.artifactTypeId = artifactTypeId;
    this.name = name;
  }

  public int getArtifactTypeId() {
    return artifactTypeId;
  }

  public void setArtifactTypeId(int artifactTypeId) {
    this.artifactTypeId = artifactTypeId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
