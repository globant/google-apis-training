package com.globant.training.google.maps.daos.objectify;

import com.google.common.collect.Lists;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.cmd.LoadType;

import com.globant.training.google.maps.daos.Dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Generic Dao Class for access to Google Data Store.
 * 
 * @author gabriel.sideri
 * @param <T> the Class of Entity to be used
 */
public class BaseOfyDao<T> implements Dao<T> {

  private final Class<T> entity;

  /**
   * Gets the {@link Objectify} service.
   * 
   * @return {@link Objectify} access
   */
  protected Objectify ofy() {
    return OfyService.ofy();
  }

  /**
   * Gets the {@link Objectify} opetations.
   * 
   * @return the {@link Objectify} opetations
   */
  protected LoadType<T> query() {
    return ofy().load().type(entity);
  }

  /**
   * Constructor to work with generics.
   * 
   * @param entity the entity to use into the DAO
   */
  protected BaseOfyDao(Class<T> entity) {
    this.entity = entity;
  }

  /**
   * Gets all entities.
   * 
   * @return all persisted entities
   */
  public List<T> getAll() {
    return ofy().load().type(entity).list();
  }

  /**
   * Save Entity.
   * 
   * @param object the entity to be persisted.
   * @return the persisted entity
   */
  public T put(T object) {
    ofy().save().entity(object).now();

    return object;
  }

  /**
   * Save a {@link Collection} of entities.
   * 
   * @param entities entities to be persisted.
   * @return the persisted entities.
   */
  public Collection<T> put(Iterable<T> entities) {
    return ofy().save().entities(entities).now().values();
  }

  /**
   * Get entity by {@link Key}.
   * 
   * @param key the entity key
   * @return the entity
   */
  public T get(Key<T> key) {
    return ofy().load().key(key).now();
  }

  /**
   * Get entity by id.
   * 
   * @param id the entity id
   * @return the entity
   */
  public T get(Long id) {
    return ofy().load().type(entity).id(id).now();
  }

  /**
   * Get entities by a list of {@link Key}.
   * 
   * @param keys list of {@link Key}
   * @return a list of entities
   */
  public List<T> get(List<Key<T>> keys) {
    return Lists.newArrayList(ofy().load().keys(keys).values());
  }

  /**
   * Checks by {@link Key} if an entity exists.
   * 
   * @param key the entity key
   * @return <b>true</b> if entity exists, otherwise <b>false</b>
   */
  public boolean exists(Key<T> key) {
    return get(key) != null;
  }

  /**
   * Checks if an entity exists.
   * 
   * @param id the entity id
   * @return <b>true</b> if entity exists, otherwise <b>false</b>
   */
  public boolean exists(Long id) {
    return get(id) != null;
  }

  /**
   * Find entities by list of ids.
   * 
   * @param ids the ids
   * @return a Map of entities
   */
  public Map<Long, T> findEntitiesByIds(List<Long> ids) {
    return new HashMap<>(ofy().load().type(entity).ids(ids));
  }

  /**
   * Delete entity.
   * 
   * @param entity the entity to be deleted
   */
  public void delete(T entity) {
    ofy().delete().entity(entity);
  }

  /**
   * Delete entity by id.
   * 
   * @param id the entity id to be deleted
   */
  public void delete(Long id) {
    Key<T> key = Key.create(entity, id);
    ofy().delete().entity(key);
  }

  /**
   * Delete a list of entities.
   * 
   * @param entities the entities to be deleted
   */
  public void delete(List<T> entities) {
    ofy().delete().entities(entities);
  }

  /**
   * Delete All Entities.
   */
  public void deleteAll() {
    List<T> entities = getAll();
    ofy().delete().entities(entities);
  }

  /**
   * Count all entities.
   * 
   * @return the quantity
   */
  public int countAll() {
    return ofy().load().type(entity).count();
  }

  /**
   * Get all Entities Paginated.
   * 
   * @param offset the offset
   * @param limit the limit
   * @return a list of entities
   */
  public List<T> getAllEntitiesPaginated(Integer offset, Integer limit) {
    return ofy().load().type(entity).offset(offset).limit(limit).list();
  }

}
