package com.andreiradzetski.links.service.impl;

import com.andreiradzetski.links.model.Domain;
import com.andreiradzetski.links.repository.LinksCrudRepository;
import com.andreiradzetski.links.service.LinksCrudService;

/**
 * @author Andrei Radzetski
 * @since 29.12.2017
 */
public abstract class LinksCrudServiceImpl<T extends Domain> implements LinksCrudService<T> {

  protected final LinksCrudRepository<T> repository;

  public LinksCrudServiceImpl(final LinksCrudRepository<T> repository) {
    this.repository = repository;
  }

  @Override
  public T save(final T entity) {
    return repository.save(entity);
  }

  @Override
  public Iterable<T> save(final Iterable<T> entities) {
    return repository.save(entities);
  }

  @Override
  public T findOne(final Long id) {
    return repository.findOne(id);
  }

  @Override
  public boolean exists(final Long id) {
    return repository.exists(id);
  }

  @Override
  public Iterable<T> findAll() {
    return repository.findAll();
  }

  @Override
  public Iterable<T> findAll(final Iterable<Long> ids) {
    return repository.findAll(ids);
  }

  @Override
  public long count() {
    return repository.count();
  }

  @Override
  public void delete(final Long id) {
    repository.delete(id);
  }

  @Override
  public void delete(final T entity) {
    repository.delete(entity);
  }

  @Override
  public void delete(final Iterable<? extends T> entities) {
    repository.delete(entities);
  }

  @Override
  public void deleteAll() {
    repository.deleteAll();
  }

}
