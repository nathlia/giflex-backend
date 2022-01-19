package br.ufsm.csi.poow2.giflex.model;

import javax.persistence.*;

@Entity
@Table(name = "artifact_substat")
public class ArtifactSubstat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "substatvalue")
    private double substatValue;

    public ArtifactSubstat() {

    }

    public ArtifactSubstat(int id) {
        this.id = id;
    }

    public ArtifactSubstat(double substatValue) {

        this.substatValue = substatValue;
    }

    public ArtifactSubstat(int id, double substatValue) {
        this.id = id;
        this.substatValue = substatValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int artifactSubstatId) {
        this.id = artifactSubstatId;
    }

    public double getSubstatValue() {
        return substatValue;
    }

    public void setSubstatValue(double substatValue) {
        this.substatValue = substatValue;
    }
}
