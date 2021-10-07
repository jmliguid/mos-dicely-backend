package com.revature.model;

// https://stackoverflow.com/questions/67886252/spring-boot-jpa-infinite-loop-many-to-many

public class JsonViewProfiles {

	/**
	 * If you need a solution for bidirectional conversion then you can use JsonView
	 * annotation.
	 * 
	 * You need to create JSON view profiles for Team and Room as shown
	 * in below example:
	 */
	public static class User {
	}

	public static class Address {
	}

}
