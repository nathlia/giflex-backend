package br.ufsm.csi.poow2.giflex.model;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int userId;

  @Column(name = "username")
  private String username;

  @Column(name = "name")
  private String name;

  @Column(name = "password")
  private String password;

  public Player() {

  }

  public Player(int userId) {
    this.userId = userId;
  }

  public Player(String Name, String Username, String Password) {
    this.name = Name;
    this.username = Username;
    this.password = Password;
  }

  public Player(int UserId, String Name, String Username, String Password) {
    this.userId = UserId;
    this.name = Name;
    this.username = Username;
    this.password = Password;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
