package br.ufsm.csi.poow2.giflex.model;

import javax.persistence.*;

@Entity
@Table(name = "character_artifact")
public class CharacterArtifact {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "character_id")
  private int characterId;

  @Column(name = "artifact_id")
  private int artifactId;

  //TODO add foreign tables
//  private Character character;
//  private Artifact artifact;

  public CharacterArtifact() {

  }

  public CharacterArtifact(int id) {
    this.id = id;
  }

  public CharacterArtifact(int characterId, int artifactId) {
    this.characterId = characterId;
    this.artifactId = artifactId;
  }

  public CharacterArtifact(int id, int characterId, int artifactId) {
    this.id = id;
    this.characterId = characterId;
    this.artifactId = artifactId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }


  public int getCharacterId() {
    return characterId;
  }

  public void setCharacterId(int characterId) {
    this.characterId = characterId;
  }


  public int getArtifactId() {
    return artifactId;
  }

  public void setArtifactId(int artifactId) {
    this.artifactId = artifactId;
  }

//  public Character getCharacter() {
//    return character;
//  }
//
//  public void setCharacter(Character character) {
//    this.character = character;
//  }
//
//  public Artifact getArtifact() {
//    return artifact;
//  }
//
//  public void setArtifact(Artifact artifact) {
//    this.artifact = artifact;
//  }

}
