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

  public CharacterArtifact() {

  }

  public CharacterArtifact(int characterId, int artifactId) {
    CharacterId = characterId;
    ArtifactId = artifactId;
  }

  public CharacterArtifact(int id, int characterId, int artifactId) {
    //this.id = id;
    CharacterId = characterId;
    ArtifactId = artifactId;
  }

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

}
