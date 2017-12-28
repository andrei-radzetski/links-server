package com.andreiradzetski.links.repository;

import com.andreiradzetski.links.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Andrei Radzetski
 * @since 10.12.2017
 */
public interface UserRepository extends CrudRepository<User, Long> {

}
