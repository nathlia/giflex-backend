package br.ufsm.csi.poow2.giflex.model;

import javax.persistence.*;

@Entity
@Table(name = "character_artifact")
public class CharacterArtifact {

  @Id
  @Column(name = "character_id")
  private int CharacterId;

  @Column(name = "artifact_id")
  private int ArtifactId;

  //TODO add foreign tables

 // private Character character;
 // private Artifact artifact;

  public CharacterArtifact() {

  }
//
//  public CharacterArtifact(int id) {
//    this.id = id;
//  }

  public CharacterArtifact(int characterId, int artifactId) {
    CharacterId = characterId;
    ArtifactId = artifactId;
  }

  public CharacterArtifact(int id, int characterId, int artifactId) {
    //this.id = id;
    CharacterId = characterId;
    ArtifactId = artifactId;
  }

//  public int getId() {
//    return id;
//  }
//
//  public void setId(int id) {
//    this.id = id;
//  }


  public int getCharacterId() {
    return CharacterId;
  }

  public void setCharacterId(int characterId) {
    this.CharacterId = characterId;
  }


  public int getArtifactId() {
    return ArtifactId;
  }

  public void setArtifactId(int artifactId) {
    this.ArtifactId = artifactId;
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
