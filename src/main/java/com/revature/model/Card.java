package com.revature.model;

import java.util.Objects;

public class Card {
	
	String image;
	String value;
	String suit;
	String code;
	
	
	public Card(String value, String suit, String code) {
		this.value = value;
		this.suit = suit;
		this.code = code;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


	public String getSuit() {
		return suit;
	}


	public void setSuit(String suit) {
		this.suit = suit;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	@Override
	public int hashCode() {
		return Objects.hash(code, image, suit, value);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return Objects.equals(code, other.code) && Objects.equals(image, other.image)
				&& Objects.equals(suit, other.suit) && Objects.equals(value, other.value);
	}


	@Override
	public String toString() {
		return "Card [code=" + code + "]";
	}
	
	
	

}