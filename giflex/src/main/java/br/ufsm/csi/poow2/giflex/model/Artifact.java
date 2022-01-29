package br.ufsm.csi.poow2.giflex.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "artifact")
public class Artifact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "mainstatvalue")
    private double mainStatValue;

    //TODO POST and PUT
    @ManyToOne
    @JoinColumn(name = "artifacttypeid", referencedColumnName = "id")
    private ArtifactType artifactType;

    @ManyToOne
    @JoinColumn(name = "artifactsettypeid", referencedColumnName = "id")
    private ArtifactSetType artifactSetType;

    @ManyToOne
    @JoinColumn(name = "mainstatid", referencedColumnName = "id")
    private Substat mainstat;

    //TODO get substat value
//
//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "artifact_substat",
//            joinColumns = @JoinColumn(name = "artifact_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "substat_id", referencedColumnName = "id")
//    )
//
//    private Set<Substat> substats = new HashSet<Substat>();
//
//    public Set<Substat> getSubstats() {
//        return this.substats;
//    }
//
//    public void setSubstats(Set<Substat> substats) {
//        this.substats = substats;
//    }

    @OneToMany(mappedBy = "artifact")
    private Set<ArtifactSubstat> artifactSubstats;

    public Artifact() {

    }

    public Artifact(double mainStatValue, ArtifactType artifactType, ArtifactSetType artifactSetType, Substat mainstat, Set<ArtifactSubstat> artifactSubstats) {
        this.mainStatValue = mainStatValue;
        this.artifactType = artifactType;
        this.artifactSetType = artifactSetType;
        this.mainstat = mainstat;
        this.artifactSubstats = artifactSubstats;
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

    public Substat getMainstat() {
        return mainstat;
    }

    public void setMainstat(Substat mainstat) {
        this.mainstat = mainstat;
    }

    public Set<ArtifactSubstat> getArtifactSubstats() {
        return artifactSubstats;
    }

    public void setArtifactSubstats(Set<ArtifactSubstat> artifactSubstats) {
        this.artifactSubstats = artifactSubstats;
    }
}
