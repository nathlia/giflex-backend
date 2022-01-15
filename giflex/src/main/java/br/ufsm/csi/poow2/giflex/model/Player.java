package br.ufsm.csi.poow2.giflex.model;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int UserId;

  @Column(name = "username")
  private String Username;

  @Column(name = "name")
  private String Name;

  @Column(name = "password")
  private String Password;

  public Player() {

  }

  public Player(int userId) {
    this.UserId= userId;
  }

  public Player(String Name, String Username, String Password) {
    this.Name = Name;
    this.Username = Username;
    this.Password = Password;
  }

  public Player(int UserId, String Name, String Username, String Password) {
    this.UserId = UserId;
    this.Name = Name;
    this.Username = Username;
    this.Password = Password;
  }

  public int getUserId() {
    return UserId;
  }

  public void setUserId(int userId) {
    this.UserId = userId;
  }


  public String getName() {
    return Name;
  }

  public void setName(String name) {
    this.Name = name;
  }


  public String getUsername() {
    return Username;
  }

  public void setUsername(String username) {
    this.Username = username;
  }


  public String getPassword() {
    return Password;
  }

  public void setPassword(String password) {
    this.Password = password;
  }

}
