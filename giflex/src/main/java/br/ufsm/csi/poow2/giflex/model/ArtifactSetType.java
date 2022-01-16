package br.ufsm.csi.poow2.giflex.model;

import javax.persistence.*;

@Entity
@Table(name = "artifactsettype")
public class ArtifactSetType {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int artifactSetTypeId;

  @Column(name = "name")
  private String name;

  @Column(name = "twopieces")
  private String twopieces;

  @Column(name = "fourpieces")
  private String fourpieces;

  public ArtifactSetType() {

  }

  public ArtifactSetType(int artifactSetTypeId) {
    this.artifactSetTypeId = artifactSetTypeId;
  }

  public ArtifactSetType(String name, String twopieces, String fourpieces) {
    this.name = name;
    this.twopieces = twopieces;
    this.fourpieces = fourpieces;
  }

  public ArtifactSetType(int artifactSetTypeId, String name, String twopieces, String fourpieces) {
    this.artifactSetTypeId = artifactSetTypeId;
    this.name = name;
    this.twopieces = twopieces;
    this.fourpieces = fourpieces;
  }

  public int getArtifactSetTypeId() {
    return artifactSetTypeId;
  }

  public void setArtifactSetTypeId(int artifactSetTypeId) {
    this.artifactSetTypeId = artifactSetTypeId;
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
}
