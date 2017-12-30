package com.andreiradzetski.links.repository;

import com.andreiradzetski.links.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @author Andrei Radzetski
 * @since 10.12.2017
 */
public interface UserRepository extends LinksCrudRepository<User> {

  @Query("select user from User user where username = :login or email = :login")
  User findByLogin(@Param("login") String login);

}
