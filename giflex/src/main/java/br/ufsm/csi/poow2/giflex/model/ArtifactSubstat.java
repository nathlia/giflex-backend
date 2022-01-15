package br.ufsm.csi.poow2.giflex.model;


import javax.persistence.*;


@Entity
@Table(name = "artifactsubstat")
public class ArtifactSubstat {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int ArtifactSubstatId;

  private int ArtifactId;

//  @Column(name = "artifacttypeid")
  private int SubstatId;

  @Column(name = "substatvalue")
  private double SubstatValue;


//  private Artifact artifact;
//  private Substat substat;

  public ArtifactSubstat() {

  }

  public ArtifactSubstat(int artifactSubstatId) {
    ArtifactSubstatId = artifactSubstatId;
  }

  public ArtifactSubstat(int artifactId, int substatId, double substatValue) {
    ArtifactId = artifactId;
    SubstatId = substatId;
    SubstatValue = substatValue;
  }

  public ArtifactSubstat(int artifactSubstatId, int artifactId, int substatId, double substatValue) {
    ArtifactSubstatId = artifactSubstatId;
    ArtifactId = artifactId;
    SubstatId = substatId;
    SubstatValue = substatValue;
  }

  public int getArtifactSubstatId() {
    return ArtifactSubstatId;
  }

  public void setArtifactSubstatId(int artifactSubstatId) {
    this.ArtifactSubstatId = artifactSubstatId;
  }

  public int getArtifactId() {
    return ArtifactId;
  }

  public void setArtifactId(int artifactId) {
    this.ArtifactId = artifactId;
  }

  public int getSubstatId() {
    return SubstatId;
  }

  public void setSubstatId(int substatId) {
    this.SubstatId = substatId;
  }


  public double getSubstatValue() {
    return SubstatValue;
  }

  public void setSubstatValue(double substatValue) {
    this.SubstatValue = substatValue;
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
