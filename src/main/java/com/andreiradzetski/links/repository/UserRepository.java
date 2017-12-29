package com.andreiradzetski.links.repository;

import com.andreiradzetski.links.model.User;

/**
 * @author Andrei Radzetski
 * @since 10.12.2017
 */
public interface UserRepository extends LinksCrudRepository<User> {

  User findByLogin(String login);

}
