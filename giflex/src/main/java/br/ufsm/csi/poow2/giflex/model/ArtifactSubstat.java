package br.ufsm.csi.poow2.giflex.model;

import javax.persistence.*;
import java.text.Format;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "artifact_substat")
public class ArtifactSubstat {

    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.AUTO)
    private ArtifactSubstatId id = new ArtifactSubstatId();

    @ManyToOne
    @MapsId("artifact")
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

    public ArtifactSubstatId getId() {
        return id;
    }

    public void setId(ArtifactSubstatId id) {
        this.id = id;
    }

    public Artifact getArtifact() {
        return artifact;
    }

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
