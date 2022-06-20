package br.ufsm.csi.poow2.giflex.model;

import javax.persistence.*;

@Entity
@Table(name = "useraccount")
public class UserAccount {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;

  @Column(name = "username", nullable = false, unique = true)
  private String username;

  @Column(name = "name")
  private String name;

  @Column(name = "password")
  private String password;

  @Column(name = "token")
  public String token;

  @Column(name = "is_admin")
  public boolean isAdmin;

//  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//  @JoinTable(
//          name = "user_character",
//          joinColumns = @JoinColumn(name = "playerid", referencedColumnName = "id"),
//          inverseJoinColumns = @JoinColumn(name = "characterid", referencedColumnName = "id")
//  )
//
//  private Set<Character> addedCharacters = new HashSet<>();

  public UserAccount() {

  }

  public UserAccount(String name, String username, String password, Boolean isAdmin) {
    this.name = name;
    this.username = username;
    this.password = password;
    this.isAdmin = isAdmin;
  }

  public UserAccount(UserAccount userAccountByUsername) {
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

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public void setAdmin(boolean admin) {
    //admin = false;
    isAdmin = admin;
  }

  public boolean isAdmin() {
    return isAdmin;
  }

  //  public Set<Character> getCharacters() {
//    return addedCharacters;
//  }
//
//  public void setCharacters(Set<Character> addedCharacters) {
//    this.addedCharacters = addedCharacters;
//  }
}
