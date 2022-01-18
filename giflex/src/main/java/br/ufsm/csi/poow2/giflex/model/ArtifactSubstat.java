package br.ufsm.csi.poow2.giflex.model;


import javax.persistence.*;


@Entity
@Table(name = "artifactsubstat")
public class ArtifactSubstat {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  private int artifactId;

//  @Column(name = "artifacttypeid")
  private int substatId;

  @Column(name = "substatvalue")
  private double substatValue;

  //TODO add foreign tables

//  private Artifact artifact;
//  private Substat substat;

  public ArtifactSubstat() {

  }

  public ArtifactSubstat(int id) {
    this.id = id;
  }

  public ArtifactSubstat(int artifactId, int substatId, double substatValue) {
    this.artifactId = artifactId;
    this.substatId = substatId;
    this.substatValue = substatValue;
  }

  public ArtifactSubstat(int id, int artifactId, int substatId, double substatValue) {
    this.id = id;
    this.artifactId = artifactId;
    this.substatId = substatId;
    this.substatValue = substatValue;
  }

  public int getId() {
    return id;
  }

  public void setId(int artifactSubstatId) {
    this.id = artifactSubstatId;
  }

  public int getArtifactId() {
    return artifactId;
  }

  public void setArtifactId(int artifactId) {
    this.artifactId = artifactId;
  }

  public int getSubstatId() {
    return substatId;
  }

  public void setSubstatId(int substatId) {
    this.substatId = substatId;
  }


  public double getSubstatValue() {
    return substatValue;
  }

  public void setSubstatValue(double substatValue) {
    this.substatValue = substatValue;
  }
//
//  public Artifact getArtifact() {
//    return artifact;
//  }
//
//  public void setArtifact(Artifact artifact) {
//    this.artifact = artifact;
//  }
//
//  public Substat getSubstat() {
//    return substat;
//  }
//
//  public void setSubstat(Substat substat) {
//    this.substat = substat;
//  }
}
