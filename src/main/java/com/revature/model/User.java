package com.revature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="players")
public class User {

	@Id
	@Column(name="player_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true)
	@NotBlank
	private String username;
	
	@Column
	@NotEmpty
	private String password;
	 
	@Column
	private int chips;
	
	public User() {super();}

	public User(int id, @NotBlank String username, @NotEmpty String password, int chips) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.chips = chips;
	}




	public User(@NotBlank String username, String password, int chips) {
		super();
		this.username = username;
		this.password = password;
		this.chips = chips;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getChips() {
		return chips;
	}

	public void setChips(int chips) {
		this.chips = chips;
	}

	@Override
	public int hashCode() {
		return Objects.hash(chips, id, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return chips == other.chips && id == other.id && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", username=" + username + ", password=" + password + ", chips=" + chips + "]";
	}

	
	
}