package br.ufsm.csi.poow2.giflex.model;

import javax.persistence.*;

@Entity
@Table(name = "artifact")
public class Artifact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "mainstatvalue")
    private double mainStatValue;

    //TODO add foreign tables
    @ManyToOne()
    @JoinColumn(name = "artifacttypeid", referencedColumnName = "id")
    private ArtifactType artifactType;

    @ManyToOne
    @JoinColumn(name = "artifactsettypeid", referencedColumnName = "id")
    private ArtifactSetType artifactSetType;

    @ManyToOne
    @JoinColumn(name = "mainstatid", referencedColumnName = "id")
    private Substat mainstat;

    //TODO add substats
//  private Substat MainStat; one to many
//  private ArrayList<Substat> Substats; many to many

    public Artifact() {

    }

    public Artifact(double mainStatValue) {
        this.mainStatValue = mainStatValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMainStatValue() {
        return mainStatValue;
    }

    public void setMainStatValue(double mainStatValue) {
        this.mainStatValue = mainStatValue;
    }

  public ArtifactType getArtifactType() {
    return artifactType;
  }

  public void setArtifactType(ArtifactType artifactType) {
    this.artifactType = artifactType;
  }

  public ArtifactSetType getArtifactSetType() {
    return artifactSetType;
  }

  public void setArtifactSetType(ArtifactSetType artifactSetType) {
    this.artifactSetType = artifactSetType;
  }

  public Substat getSubstat() {
    return mainstat;
  }

  public void setSubstat(Substat mainstat) {
    this.mainstat = mainstat;
  }
}
