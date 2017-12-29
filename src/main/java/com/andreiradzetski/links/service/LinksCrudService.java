package com.andreiradzetski.links.service;

import com.andreiradzetski.links.model.Domain;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * @author Andrei Radzetski
 * @since 29.12.2017
 */
public interface LinksCrudService<T extends Domain> {

  /**
   * See {@link CrudRepository#save(Object)}.
   */
  T save(T entity);

  /**
   * See {@link CrudRepository#save(Iterable)}.
   */
  Iterable<T> save(Iterable<T> entities);

  /**
   * See {@link CrudRepository#findOne(Serializable)}.
   */
  T findOne(Long id);

  /**
   * See {@link CrudRepository#exists(Serializable)}.
   */
  boolean exists(Long id);

  /**
   * See {@link CrudRepository#findAll()}.
   */
  Iterable<T> findAll();

  /**
   * See {@link CrudRepository#findAll(Iterable)}.
   */
  Iterable<T> findAll(Iterable<Long> ids);

  /**
   * See {@link CrudRepository#count()}.
   */
  long count();

  /**
   * See {@link CrudRepository#delete(Serializable)}.
   */
  void delete(Long id);

  /**
   * See {@link CrudRepository#delete(Object)}.
   */
  void delete(T entity);

  /**
   * See {@link CrudRepository#delete(Iterable)}.
   */
  void delete(Iterable<? extends T> entities);

  /**
   * See {@link CrudRepository#deleteAll()}.
   */
  void deleteAll();

}
