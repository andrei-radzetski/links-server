package com.andreiradzetski.links.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Andrei Radzetski
 * @since 10.12.2017
 */
@Entity
@Table(name = "USERS")
@SequenceGenerator(name = "USERS_SEQ", sequenceName = "USERS_SEQ", allocationSize = 1)
public class User implements Domain {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
  private Long id;

  @Column(nullable = false, unique = true)
  private String login;

  @Column(nullable = false)
  private String password;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private Set<Permission> permissions;

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Permission> getPermissions() {

    if (permissions == null) {
      permissions = new HashSet<>();
    }

    return permissions;
  }

}
