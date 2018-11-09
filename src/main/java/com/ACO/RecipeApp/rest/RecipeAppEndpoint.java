package com.ACO.RecipeApp.rest;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.ACO.RecipeApp.repository.RecipeAppRepository;
import com.ACO.RecipeApp.domain.Recipes;

@Path("/user")
public class RecipeAppEndpoint {

	@Inject
	private RecipeAppRepository classRepo;

	@Path("/getAllUsers")
	@GET
	@Produces({ "application/json" })
	public String getAllUsers() {
		return classRepo.getAllUsers();
	}

	@Path("/getUser/{id}")
	@GET
	@Produces({ "application/json" })
	public String getUser(@PathParam("id") Long userID) {
		return classRepo.getUser(userID);
	}

	@Path("/createaUser")
	@POST
	@Produces({ "application/json" })
	public String createaUser(String user) {
		return classRepo.createUser(user);
	}

	@Path("/updateUser/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateUser(@PathParam("id") Long userID, String user) {
		{
			return classRepo.updateUser(userID, user);
		}
	}

	@Path("/deleteUser/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteUser(@PathParam("id") Long userID) {
		return classRepo.deleteUser(userID);
	}

	public void setService(RecipeAppRepository classRepo) {
		this.classRepo = classRepo;
	}

}