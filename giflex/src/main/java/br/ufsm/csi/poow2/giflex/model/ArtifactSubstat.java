package br.ufsm.csi.poow2.giflex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "artifact_substat")
public class ArtifactSubstat {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ArtifactSubstatId id = new ArtifactSubstatId();

    @ManyToOne
    @MapsId("artifact")
    @JsonIgnore
    private Artifact artifact;

    @ManyToOne
    @MapsId("substat")
    private Substat substat;

    @Column(name = "substatvalue")
    private double substatValue;

    public ArtifactSubstat() {

    }

    public ArtifactSubstat(ArtifactSubstatId id, Artifact artifact, Substat substat, double substatValue) {
        this.id = id;
        this.artifact = artifact;
        this.substat = substat;
        this.substatValue = substatValue;
    }

    public ArtifactSubstat(Artifact artifact, Substat substat, double substatValue) {
    }

    public ArtifactSubstatId getId() {
        return id;
    }

    public void setId(ArtifactSubstatId id) {
        this.id = id;
    }

    @JsonIgnore
    public Artifact getArtifact() {
        return artifact;
    }

    @JsonIgnore
    public void setArtifact(Artifact artifact) {
        this.artifact = artifact;
    }

    public Substat getSubstat() {
        return substat;
    }

    public void setSubstat(Substat substat) {
        this.substat = substat;
    }

    public double getSubstatValue() {
        return substatValue;
    }

    public void setSubstatValue(double substatValue) {
        this.substatValue = substatValue;
    }
}
