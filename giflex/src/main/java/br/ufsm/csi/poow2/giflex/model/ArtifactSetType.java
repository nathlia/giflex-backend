package br.ufsm.csi.poow2.giflex.model;

import javax.persistence.*;

@Entity
@Table(name = "artifactsettype")
public class ArtifactSetType {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int ArtifactSetTypeId;

  @Column(name = "name")
  private String Name;

  @Column(name = "description")
  private String Description;

  public ArtifactSetType() {

  }

  public ArtifactSetType(int artifactSetTypeId) {
    ArtifactSetTypeId = artifactSetTypeId;
  }

  public ArtifactSetType(String name, String description) {
    Name = name;
    Description = description;
  }

  public ArtifactSetType(int artifactSetTypeId, String name, String description) {
    ArtifactSetTypeId = artifactSetTypeId;
    Name = name;
    Description = description;
  }

  public int getArtifactSetTypeId() {
    return ArtifactSetTypeId;
  }

  public void setArtifactSetTypeId(int artifactSetTypeId) {
    this.ArtifactSetTypeId = artifactSetTypeId;
  }


  public String getName() {
    return Name;
  }

  public void setName(String name) {
    this.Name = name;
  }


  public String getDescription() {
    return Description;
  }

  public void setDescription(String description) {
    this.Description = description;
  }

}
