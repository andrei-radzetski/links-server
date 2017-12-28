package com.andreiradzetski.links.model;

import javax.persistence.*;

/**
 * @author Andrei Radzetski
 * @since 10.12.2017
 */
@Entity
@Table(name = "PERMISSIONS")
@SequenceGenerator(name = "PERMISSIONS_SEQ", sequenceName = "PERMISSIONS_SEQ", allocationSize = 1)
public class Permission implements Domain {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERMISSIONS_SEQ")
  private Long id;

  @ManyToOne(optional = false)
  @JoinColumn(name = "USER_ID")
  private User user;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private Role role;

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

}
