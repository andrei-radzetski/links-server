package com.andreiradzetski.links.service.impl;

import com.andreiradzetski.links.model.User;
import com.andreiradzetski.links.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Andrei Radzetski
 * @since 29.12.2017
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserService userService;

  public UserDetailsServiceImpl(final UserService userService) {
    this.userService = userService;
  }

  @Override
  @Transactional
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

    final User user = userService.findByLogin(username);

    if (user == null) {
      throw new UsernameNotFoundException(username);
    }

    Hibernate.initialize(user.getPermissions());

    return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), user.getPermissions());
  }

}
