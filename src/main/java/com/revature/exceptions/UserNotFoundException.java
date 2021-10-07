package com.revature.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserNotFoundException extends RuntimeException{

	
	public UserNotFoundException(String message) {
		super(message);
	}

	public UserNotFoundException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public UserNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public UserNotFoundException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	
	
}