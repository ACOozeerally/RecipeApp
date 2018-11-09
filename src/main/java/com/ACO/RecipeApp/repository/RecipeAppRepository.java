package com.ACO.RecipeApp.repository;

public interface RecipeAppRepository {

	String getAllUsers();

	String createUser(String user);

	String deleteUser(Long userID);

	String getUser(Long userID);

	String updateUser(Long id, String classroom);
	
}
