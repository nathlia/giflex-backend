package br.ufsm.csi.poow2.giflex.model;

import javax.persistence.*;

@Entity
@Table(name = "usercharacter")
public class UserCharacter {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "playerid")
  private int playerId;

  @Column(name = "characterid")
  private int characterId;

  public UserCharacter() {

  }

  public UserCharacter(int id) {
    this.id = id;
  }

  public UserCharacter( int characterId, int playerId) {
    this.characterId = characterId;
    this.playerId = playerId;
  }

  public UserCharacter(int id, int characterId, int playerId) {
    this.id = id;
    this.playerId = playerId;
    this.characterId = characterId;
  }

  public int getId() {
    return id;
  }

  public void setId(int userCharacterId) {
    this.id = userCharacterId;
  }


  public int getPlayerId() {
    return playerId;
  }

  public void setPlayerId(int playerId) {
    this.playerId = playerId;
  }


  public int getCharacterId() {
    return characterId;
  }

  public void setCharacterId(int characterId) {
    this.characterId = characterId;
  }

}
