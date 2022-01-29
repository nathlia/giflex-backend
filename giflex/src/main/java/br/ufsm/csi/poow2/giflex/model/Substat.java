package br.ufsm.csi.poow2.giflex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "substat")
public class Substat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "mainstat")
    @JsonIgnore
    private Set<Artifact> artifacts;

    @OneToMany(mappedBy = "substat")
    @JsonIgnore
    private Set<ArtifactSubstat> artifactSubstats;

    public Substat() {
    }

    public Substat(String name, Set<Artifact> artifacts, Set<ArtifactSubstat> artifactSubstats) {
        this.name = name;
        this.artifacts = artifacts;
        this.artifactSubstats = artifactSubstats;
    }

    public int getId() {
        return id;
    }

    public void setId(int substatId) {
        this.id = substatId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public Set<Artifact> getArtifacts() {
        return artifacts;
    }

    @JsonIgnore
    public void setArtifacts(Set<Artifact> artifacts) {
        this.artifacts = artifacts;
    }


    @JsonIgnore
    public Set<ArtifactSubstat> getArtifactSubstats() {
        return artifactSubstats;
    }

    @JsonIgnore
    public void setArtifactSubstats(Set<ArtifactSubstat> artifactSubstats) {
        this.artifactSubstats = artifactSubstats;
    }
}
