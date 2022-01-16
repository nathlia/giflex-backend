package br.ufsm.csi.poow2.giflex.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "artifact")
public class Artifact {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int ArtifactId;

  @Column(name = "artifacttypeid")
  private int ArtifactTypeId;

  @Column(name = "artifactsettypeid")
  private int ArtifactSetTypeId;

  @Column(name = "mainstatid")
  private int MainStatId;

  @Column(name = "mainstatvalue")
  private double MainStatValue;

  //TODO add foreign tables

//  private ArtifactType artifactType;
//  private ArtifactSetType artifactSetType;
//  private Substat MainStat;
//  private ArrayList<Substat> Substats;

  public Artifact() {

  }

  public Artifact(int artifactId) {
    ArtifactId = artifactId;
  }

  public Artifact(int artifactId, int artifactTypeId, int artifactSetTypeId, int mainStatId, double mainStatValue) {
    ArtifactId = artifactId;
    ArtifactTypeId = artifactTypeId;
    ArtifactSetTypeId = artifactSetTypeId;
    MainStatId = mainStatId;
    MainStatValue = mainStatValue;
  }

  public Artifact(int artifactTypeId, int artifactSetTypeId, int mainStatId, double mainStatValue) {
    ArtifactTypeId = artifactTypeId;
    ArtifactSetTypeId = artifactSetTypeId;
    MainStatId = mainStatId;
    MainStatValue = mainStatValue;
  }

  public int getArtifactId() {
    return ArtifactId;
  }

  public void setArtifactId(int artifactId) {
    ArtifactId = artifactId;
  }

  public int getArtifactTypeId() {
    return ArtifactTypeId;
  }

  public void setArtifactTypeId(int artifactTypeId) {
    ArtifactTypeId = artifactTypeId;
  }

  public int getArtifactSetTypeId() {
    return ArtifactSetTypeId;
  }

  public void setArtifactSetTypeId(int artifactSetTypeId) {
    ArtifactSetTypeId = artifactSetTypeId;
  }

  public int getMainStatId() {
    return MainStatId;
  }

  public void setMainStatId(int mainStatId) {
    MainStatId = mainStatId;
  }

  public double getMainStatValue() {
    return MainStatValue;
  }

  public void setMainStatValue(double mainStatValue) {
    MainStatValue = mainStatValue;
  }

//  public ArtifactType getArtifactType() {
//    return artifactType;
//  }
//
//  public void setArtifactType(ArtifactType artifactType) {
//    this.artifactType = artifactType;
//  }
//
//  public ArtifactSetType getArtifactSetType() {
//    return artifactSetType;
//  }
//
//  public void setArtifactSetType(ArtifactSetType artifactSetType) {
//    this.artifactSetType = artifactSetType;
//  }
//
//  public Substat getMainStat() {
//    return MainStat;
//  }
//
//  public void setMainStat(Substat mainStat) {
//    MainStat = mainStat;
//  }
//
//  public ArrayList<Substat> getSubstats() {
//    return Substats;
//  }
//
//  public void setSubstats(ArrayList<Substat> substats) {
//    Substats = substats;
//  }

}
