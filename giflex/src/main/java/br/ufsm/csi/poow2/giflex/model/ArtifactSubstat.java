package br.ufsm.csi.poow2.giflex.model;


import com.sun.xml.bind.v2.TODO;

import javax.persistence.*;


@Entity
@Table(name = "artifactsubstat")
public class ArtifactSubstat {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int artifactSubstatId;

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

  public ArtifactSubstat(int artifactSubstatId) {
    this.artifactSubstatId = artifactSubstatId;
  }

  public ArtifactSubstat(int artifactId, int substatId, double substatValue) {
    this.artifactId = artifactId;
    this.substatId = substatId;
    this.substatValue = substatValue;
  }

  public ArtifactSubstat(int artifactSubstatId, int artifactId, int substatId, double substatValue) {
    this.artifactSubstatId = artifactSubstatId;
    this.artifactId = artifactId;
    this.substatId = substatId;
    this.substatValue = substatValue;
  }

  public int getArtifactSubstatId() {
    return artifactSubstatId;
  }

  public void setArtifactSubstatId(int artifactSubstatId) {
    this.artifactSubstatId = artifactSubstatId;
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
