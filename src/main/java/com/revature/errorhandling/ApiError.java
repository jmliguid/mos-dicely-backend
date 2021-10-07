package com.revature.errorhandling;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.Getter;

/*
 * @Data is a convenient shortcut annotation that bundles the features
 * of @ToString , @EqualsAndHashCode , @Getter / @Setter
 * and @RequiredArgsConstructor together: In other words, @Data generates all
 * the boilerplate that is normally associated with simple POJOs (Plain Old Java
 * Objects) and beans
 */
@Data
public class ApiError {
	
	/*
	 * This class is designed to represent information about an HTTP Error.
	 * 
	 * The structure of this class can be serialized into JSON and sent
	 * back to the client about what went wrong.
	 */
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	
	private int status;
	
	private String error; // represetns our HTTP error (in words)

	private String message;
	private String debugMessage;
	List<ApiSubError> subErrors = new ArrayList<>();
	
	protected ApiError() {
		super();
		timestamp = LocalDateTime.now();
	}
	
	public ApiError(HttpStatus status) {
		this();
		this.status = status.value(); 
		this.error = status.getReasonPhrase();
	}
	
	public ApiError(HttpStatus status, Throwable ex) {
		this(status);
		this.message = "No message available";
		this.debugMessage = ex.getLocalizedMessage();
	}
	
	public ApiError(HttpStatus status, String message, Throwable ex) {
		this(status, ex);
		this.message = message;
	}
	
	public void addSubError(ApiSubError error) {
		
		this.subErrors.add(error);
	}
	
	
	
}






