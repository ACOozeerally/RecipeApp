package com.ACO.RecipeApp.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.ACO.RecipeApp.domain.Recipes;

@Entity
public class Users {

	public Users() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_ID")
	private Long userID;
	@Column(length = 100)
	private String firstName;
	@Column(length = 100)
	private String lastName;
	@JoinColumn(name = "user_ID", referencedColumnName = "user_ID")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Recipes> recipes;

	public Users(Long userID, String firstName, String lastName, List<Recipes> recipes) {
		this.userID = userID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.recipes = recipes;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Recipes> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipes> recipes) {
		this.recipes = recipes;
	}

}
