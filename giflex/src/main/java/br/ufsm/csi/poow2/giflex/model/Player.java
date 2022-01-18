package br.ufsm.csi.poow2.giflex.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "player")
public class Player {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "username")
  private String username;

  @Column(name = "name")
  private String name;

  @Column(name = "password")
  private String password;

//  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//  @JoinTable(
//          name = "usercharacter",
//          joinColumns = @JoinColumn(name = "playerid", referencedColumnName = "id"),
//          inverseJoinColumns = @JoinColumn(name = "characterid", referencedColumnName = "id")
//  )
//
//  private Set<Character> addedCharacters = new HashSet<>();

  public Player() {

  }

  public Player(String name, String username, String password) {
    this.name = name;
    this.username = username;
    this.password = password;
  }

  public int getId() {
    return id;
  }

  public void setId(int userId) {
    this.id = userId;
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

//  public Set<Character> getCharacters() {
//    return addedCharacters;
//  }
//
//  public void setCharacters(Set<Character> addedCharacters) {
//    this.addedCharacters = addedCharacters;
//  }
}
