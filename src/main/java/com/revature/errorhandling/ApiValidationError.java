package com.revature.errorhandling;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ApiValidationError extends ApiSubError{

	private String object; // the type
	private String field; // field name
	private Object rejectedValue; // the particular value
	private String message; // the reason
	
	public ApiValidationError(String object, String message) {
		
		this.object = object;
		this.message = message;
		
	}
	
	public ApiValidationError(String object, String message, String field) {
		this(object, message);
		this.field = field;
	}
	
	public ApiValidationError(String object, String message, String field, Object rejectedValue) {
		this(object, message, field);
		this.rejectedValue = rejectedValue;
	}
}