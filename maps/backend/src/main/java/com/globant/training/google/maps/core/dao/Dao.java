package com.globant.training.google.maps.core.dao;

import com.googlecode.objectify.Key;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Generic Dao Interface.
 * 
 * @author gabriel.sideri
 * @param <T> the Class of Entity to be used
 */
public interface Dao<T> {

  /**
   * Gets all entities.
   * 
   * @return all persisted entities
   */
  List<T> getAll();

  /**
   * Save Entity.
   * 
   * @param object the entity to be persisted.
   * @return the persisted entity
   */
  T put(T object);

  /**
   * Save a {@link Collection} of entities.
   * 
   * @param entities entities to be persisted.
   * @return the persisted entities.
   */
  Collection<T> put(Iterable<T> entities);

  /**
   * Get entity by {@link Key}.
   * 
   * @param key the entity key
   * @return the entity
   */
  T get(Key<T> key);

  /**
   * Get entity by id.
   * 
   * @param id the entity id
   * @return the entity
   */
  T get(Long id);

  /**
   * Get entities by a list of {@link Key}.
   * 
   * @param keys list of {@link Key}
   * @return a list of entities
   */
  List<T> get(List<Key<T>> keys);

  /**
   * Checks by {@link Key} if an entity exists.
   * 
   * @param key the entity key
   * @return <b>true</b> if entity exists, otherwise <b>false</b>
   */
  boolean exists(Key<T> key);

  /**
   * Checks if an entity exists.
   * 
   * @param id the entity id
   * @return <b>true</b> if entity exists, otherwise <b>false</b>
   */
  boolean exists(Long id);

  /**
   * Find entities by list of ids.
   * 
   * @param ids the ids
   * @return a Map of entities
   */
  Map<Long, T> findEntitiesByIds(List<Long> ids);

  /**
   * Delete entity.
   * 
   * @param entity the entity to be deleted
   */
  void delete(T entity);

  /**
   * Delete entity by id.
   * 
   * @param id the entity id to be deleted
   */
  void delete(Long id);

  /**
   * Delete a list of entities.
   * 
   * @param entities the entities to be deleted
   */
  void delete(List<T> entities);

  /**
   * Delete All Entities.
   */
  void deleteAll();

  /**
   * Count all entities.
   * 
   * @return the quantity
   */
  int countAll();

  /**
   * Get all Entities Paginated.
   * 
   * @param offset the offset
   * @param limit the limit
   * @return a list of entities
   */
  List<T> getAllEntitiesPaginated(Integer offset, Integer limit);

}
