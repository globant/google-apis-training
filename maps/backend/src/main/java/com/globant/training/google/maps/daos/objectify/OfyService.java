package com.globant.training.google.maps.daos.objectify;

import com.globant.training.google.maps.entities.UserEntity;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

/**
 * @author gabriel.sideri
 */
public class OfyService {

	//Register all entities //
	static {
		ObjectifyService.register(UserEntity.class);
	}

	public static Objectify ofy() {
		return ObjectifyService.ofy();
	}

	public static ObjectifyFactory factory() {
		return ObjectifyService.factory();
	}
}
