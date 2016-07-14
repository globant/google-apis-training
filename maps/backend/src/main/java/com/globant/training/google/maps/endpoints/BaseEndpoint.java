package com.globant.training.google.maps.endpoints;

import com.google.appengine.api.users.User;

public class BaseEndpoint {

	protected boolean isAdmin(User user) {
		if (user.getEmail().equals("example@example.com")) {
			return true;
		}
		return true;
	}
	
}
