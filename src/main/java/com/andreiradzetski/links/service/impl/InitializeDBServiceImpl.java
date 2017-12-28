package com.andreiradzetski.links.service.impl;

import com.andreiradzetski.links.model.Permission;
import com.andreiradzetski.links.model.Role;
import com.andreiradzetski.links.model.User;
import com.andreiradzetski.links.repository.UserRepository;
import com.andreiradzetski.links.service.InitializeDBService;
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

  private UserRepository userRepository;

  @Autowired
  public InitializeDBServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @PostConstruct
  private void initialize() {

    if (userRepository.count() == 0) {

      logger.info("Users table is empty, initialing data...");
      createAdmin();
      createUser();
    }
  }

  @Override
  public void createAdmin() {

    final User user = new User();
    final Permission permissionAdmin = new Permission();
    final Permission permissionActuator = new Permission();
    final Permission permissionUser = new Permission();

    permissionAdmin.setRole(Role.ADMIN);
    permissionAdmin.setUser(user);

    permissionActuator.setRole(Role.ACTUATOR);
    permissionActuator.setUser(user);

    permissionUser.setRole(Role.USER);
    permissionUser.setUser(user);

    user.setLogin("admin");
    user.setPassword("admin");
    user.getPermissions().add(permissionAdmin);
    user.getPermissions().add(permissionActuator);
    user.getPermissions().add(permissionUser);

    userRepository.save(user);

    logger.info("User with login \"{}\" was created.", user.getLogin());
  }

  @Override
  public void createUser() {

    final User user = new User();
    final Permission permissionUser = new Permission();

    permissionUser.setRole(Role.USER);
    permissionUser.setUser(user);

    user.setLogin("user");
    user.setPassword("user");
    user.getPermissions().add(permissionUser);

    userRepository.save(user);

    logger.info("User with login \"{}\" was created.", user.getLogin());
  }

}
