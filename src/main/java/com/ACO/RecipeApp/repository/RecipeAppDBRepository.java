package com.ACO.RecipeApp.repository;

import static javax.transaction.Transactional.TxType.*;

import java.util.Collection;
import java.util.List;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.ACO.RecipeApp.Util.JSONUtil;
import com.ACO.RecipeApp.domain.Users;
import com.ACO.RecipeApp.domain.Recipes;

@Transactional(SUPPORTS)
@Default
public class RecipeAppDBRepository implements RecipeAppRepository {

	@Inject
	private JSONUtil util;

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	public String getAllUsers() {
		Query query = manager.createQuery("Select a FROM Users a");
		Collection<Users> users = (Collection<Users>) query.getResultList();
		return util.getJSONForObject(users);
	}

	@Override
	public String createUser(String user) {
		Users aUser = util.getObjectForJSON(user, Users.class);
		manager.merge(aUser);
		return "{\"message\": \"User sucessfully added\"}";
	}

	@Override
	public String deleteUser(Long userID) {
		Users userInDB = findUser(userID);
		if (userInDB != null) {
			manager.remove(userInDB);
		}
		return "{\"message\": \"User sucessfully deleted\"}";
	}

	@Override
	public String getUser(Long userID) {
		Users aUser = manager.find(Users.class, userID);
		return util.getJSONForObject(aUser);
	}

	@Override
	public String updateUser(Long userID, String user) {
		Users aUser = util.getObjectForJSON(user, Users.class);
		Users userInDB = findUser(userID);
		userInDB.setFirstName(aUser.getFirstName());
		userInDB.setRecipes(aUser.getRecipes());

		return "{\"message\": \"User has been sucessfully updated\"}";
	}
	
	private Users findUser(Long userID) {
		return manager.find(Users.class, userID);
	}

}
