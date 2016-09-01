package com.globant.training.google.maps.user.dao.objectify;

import com.globant.training.google.maps.core.dao.objectify.BaseOfyDao;
import com.globant.training.google.maps.user.dao.UserDao;
import com.globant.training.google.maps.user.entity.AppUser;

import java.util.List;

/**
 * User Objectify DAO.
 * 
 * @author gabriel.sideri
 */
public class UserOfyDao extends BaseOfyDao<AppUser> implements UserDao {

  public UserOfyDao() {
    super(AppUser.class);
  }

  @Override
  public AppUser findByGoogleId(String googleId) {
    return this.query().filter(AppUser.GOOGLE_ID_FIELD, googleId).first().now();
  }

  @Override
  public List<AppUser> findUsersPaginated(Integer offset, Integer limit) {
    return this.getAllEntitiesPaginated(offset, limit);
  }

}
