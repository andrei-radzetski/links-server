package com.andreiradzetski.links.model;

import org.springframework.security.core.userdetails.UserDetails;

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
public class User implements Domain, UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
  private Long id;

  @Column(nullable = false, unique = true)
  private String email;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String password;

  private String name;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private Set<Authority> authorities;

  @Column(nullable = false, columnDefinition = "number(1) default 1")
  private boolean accountNonExpired = true;

  @Column(nullable = false, columnDefinition = "number(1) default 1")
  private boolean accountNonLocked = true;

  @Column(nullable = false, columnDefinition = "number(1) default 1")
  private boolean credentialsNonExpired = true;

  @Column(nullable = false, columnDefinition = "number(1) default 1")
  private boolean enabled = true;

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  @Override
  public String getUsername() {
    return username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  @Override
  public String getPassword() {
    return password;
  }

  public void setPassword(final String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }

  @Override
  public Set<Authority> getAuthorities() {

    if (authorities == null) {
      authorities = new HashSet<>();
    }
    return authorities;
  }

  @Override
  public boolean isAccountNonExpired() {
    return accountNonExpired;
  }

  public void setAccountNonExpired(final boolean accountNonExpired) {
    this.accountNonExpired = accountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return accountNonLocked;
  }

  public void setAccountNonLocked(final boolean accountNonLocked) {
    this.accountNonLocked = accountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return credentialsNonExpired;
  }

  public void setCredentialsNonExpired(final boolean credentialsNonExpired) {
    this.credentialsNonExpired = credentialsNonExpired;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(final boolean enabled) {
    this.enabled = enabled;
  }

}
