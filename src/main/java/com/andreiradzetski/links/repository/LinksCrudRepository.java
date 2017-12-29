package com.andreiradzetski.links.repository;

import com.andreiradzetski.links.model.Domain;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @author Andrei Radzetski
 * @since 29.12.2017
 */
@NoRepositoryBean
public interface LinksCrudRepository<T extends Domain> extends CrudRepository<T, Long> {

}
