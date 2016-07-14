package com.globant.training.google.maps.daos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.globant.training.google.maps.daos.objectify.OfyService;
import com.globant.training.google.maps.entities.BaseEntity;
import com.google.common.collect.Lists;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.cmd.LoadType;


/**
 * @author gabriel.sideri
 *
 * @param <T> 
 */
public class BaseDao <T extends BaseEntity> {

	private final Class<T> entity;

	protected BaseDao(Class<T> entity) {
		this.entity = entity;
	}

	public List<T> getAll() {
		return ofy().load().type(entity).list();
	}

	public T put(T object) {
		ofy().save().entity(object).now();

		return object;
	}

	public Collection<T> put(Iterable<T> entities) {
		return ofy().save().entities(entities).now().values();
	}

	public T get(Key<T> key) {
		return ofy().load().key(key).now();
	}

	public T get(Long id) {
		return ofy().load().type(entity).id(id).now();
	}

	public Boolean exists(Key<T> key) {
		return get(key) != null;
	}

	public Boolean exists(Long id) {
		return get(id) != null;
	}

	public List<T> getSubset(List<Long> ids) {
		return new ArrayList<>(ofy().load().type(entity).ids(ids).values());
	}

	public Map<Long, T> getSubsetMap(List<Long> ids) {
		return new HashMap<>(ofy().load().type(entity).ids(ids));
	}

	public void delete(T object) {
		ofy().delete().entity(object);
	}

	public void delete(Long id) {
		Key<T> key = Key.create(entity, id);
		ofy().delete().entity(key);
	}

	public void delete(List<T> objects) {
		ofy().delete().entities(objects);
	}

	public void deleteAll() {
		List<T> entities = getAll();
		ofy().delete().entities(entities);
	}

	public List<T> get(List<Key<T>> keys) {
		return Lists.newArrayList(ofy().load().keys(keys).values());
	}

	public int countAll() {
		return ofy().load().type(entity).count();
	}

	public List<T> getSome(Integer offset, Integer limit) {
		return ofy().load().type(entity).offset(offset).limit(limit).list();
	}

	protected Objectify ofy() {
		return OfyService.ofy();
	}

	protected LoadType<T> query() {
		return ofy().load().type(entity);
	}

}
