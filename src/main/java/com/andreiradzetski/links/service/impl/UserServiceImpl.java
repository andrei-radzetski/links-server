package com.andreiradzetski.links.service.impl;

import com.andreiradzetski.links.model.User;
import com.andreiradzetski.links.repository.UserRepository;
import com.andreiradzetski.links.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Andrei Radzetski
 * @since 29.12.2017
 */
@Service
public class UserServiceImpl extends LinksCrudServiceImpl<User> implements UserService {

  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public UserServiceImpl(final UserRepository userRepository, final BCryptPasswordEncoder bCryptPasswordEncoder) {

    super(userRepository);
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @Override
  public User findByLogin(final String login) {
    return ((UserRepository) repository).findByLogin(login);
  }

  @Override
  public User save(final User entity) {

    entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));

    return super.save(entity);
  }

  @Override
  public Iterable<User> save(final Iterable<User> entities) {

    entities.forEach(user -> user.setPassword(bCryptPasswordEncoder.encode(user.getPassword())));

    return super.save(entities);
  }
}
