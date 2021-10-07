package com.revature.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="players")
public class Player {

	@Id
	@Column(name="player_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private int wallet;
	
	@Column
	private int chips;

	public Player() {
		super();
	}

	public Player(String username, String password, int wallet, int chips) {
		super();
		this.username = username;
		this.password = password;
		this.wallet = wallet;
		this.chips = chips;
	}

	public Player(int id, String username, String password, int wallet, int chips) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.wallet = wallet;
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

	public int getWallet() {
		return wallet;
	}

	public void setWallet(int wallet) {
		this.wallet = wallet;
	}

	public int getChips() {
		return chips;
	}

	public void setChips(int chips) {
		this.chips = chips;
	}

	@Override
	public int hashCode() {
		return Objects.hash(chips, id, password, username, wallet);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		return chips == other.chips && id == other.id && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username) && wallet == other.wallet;
	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", username=" + username + ", password=" + password + ", wallet=" + wallet
				+ ", chips=" + chips + "]";
	}
	
	
	
}