package com.andreiradzetski.links.service.impl;

import com.andreiradzetski.links.model.Authority;
import com.andreiradzetski.links.model.Role;
import com.andreiradzetski.links.model.User;
import com.andreiradzetski.links.service.InitializeDBService;
import com.andreiradzetski.links.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author Andrei Radzetski
 * @since 11.12.2017
 */
@Service
public class InitializeDBServiceImpl implements InitializeDBService {

  private final Logger logger = LoggerFactory.getLogger(InitializeDBService.class);

  private final UserService userService;

  @Autowired
  public InitializeDBServiceImpl(final UserService userService) {
    this.userService = userService;
  }

  @PostConstruct
  private void initialize() {

    if (userService.count() == 0) {

      logger.info("Users table is empty, initialing data...");
      createAdmin();
      createUser();
    }
  }

  @Override
  public void createAdmin() {

    final User user = new User();
    final Authority authorityAdmin = new Authority();
    final Authority authorityActuator = new Authority();
    final Authority authorityUser = new Authority();

    authorityAdmin.setRole(Role.ADMIN);
    authorityAdmin.setUser(user);

    authorityActuator.setRole(Role.ACTUATOR);
    authorityActuator.setUser(user);

    authorityUser.setRole(Role.USER);
    authorityUser.setUser(user);

    user.setEmail("admin@links.com");
    user.setUsername("admin");
    user.setPassword("admin");
    user.setName("Admin");
    user.getAuthorities().add(authorityAdmin);
    user.getAuthorities().add(authorityActuator);
    user.getAuthorities().add(authorityUser);

    userService.save(user);

    logger.info("User with username \"{}\" was created.", user.getUsername());
  }

  @Override
  public void createUser() {

    final User user = new User();
    final Authority authorityUser = new Authority();

    authorityUser.setRole(Role.USER);
    authorityUser.setUser(user);

    user.setEmail("user@links.com");
    user.setUsername("user");
    user.setPassword("user");
    user.setName("User");
    user.getAuthorities().add(authorityUser);

    userService.save(user);

    logger.info("User with username \"{}\" was created.", user.getUsername());
  }

}
