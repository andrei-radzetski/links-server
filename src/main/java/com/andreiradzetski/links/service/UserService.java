package com.andreiradzetski.links.service;

import com.andreiradzetski.links.model.User;

/**
 * @author Andrei Radzetski
 * @since 29.12.2017
 */
public interface UserService extends LinksCrudService<User> {

  User findByLogin(String login);

}
