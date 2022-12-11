package br.ufsm.csi.poow2.giflex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "artifact")
public class Artifact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "mainstatvalue")
    private double mainStatValue;

    @ManyToOne
    @JoinColumn(name = "artifacttypeid", referencedColumnName = "id", unique = true)
    private ArtifactType artifactType;

    @ManyToOne
    @JoinColumn(name = "artifactsettypeid", referencedColumnName = "id")
    private ArtifactSetType artifactSetType;

    @ManyToOne
    @JoinColumn(name = "mainstatid", referencedColumnName = "id")
    private Substat mainstat;

    @OneToMany(mappedBy = "artifact")
    private Set<ArtifactSubstat> artifactSubstats;

    //characters
    @ManyToMany(mappedBy = "equippedArtifacts", cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Character> characters = new HashSet<>();

    public Artifact() {

    }

    public Artifact(double mainStatValue, ArtifactType artifactType, ArtifactSetType artifactSetType, Substat mainstat, Set<ArtifactSubstat> artifactSubstats) {
        this.mainStatValue = mainStatValue;
        this.artifactType = artifactType;
        this.artifactSetType = artifactSetType;
        this.mainstat = mainstat;
        this.artifactSubstats = artifactSubstats;
    }

    public Artifact(double mainStatValue, ArtifactType artifactType, ArtifactSetType artifactSetType, Substat mainstat, Set<ArtifactSubstat> artifactSubstats, Set<Character> characters) {
        this.mainStatValue = mainStatValue;
        this.artifactType = artifactType;
        this.artifactSetType = artifactSetType;
        this.mainstat = mainstat;
        this.characters = characters;
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

    public Set<Character> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

    public void addCharacter(Character character) {
        this.characters.add(character);
        character.getEquippedArtifacts().add(this);
    }

    public void removeCharacter(Character character) {
        this.characters.remove(character);
        character.getEquippedArtifacts().remove(this);
    }

}
