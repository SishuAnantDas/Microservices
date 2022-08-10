
package com.sis.expt.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sis.expt.exception.UserNotFoundException;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleInvalidArguments(MethodArgumentNotValidException ex) {

		Map<String, String> erroMap = new HashMap<>();

		ex.getBindingResult().getFieldErrors()
				.forEach(error -> erroMap.put(error.getField(), error.getDefaultMessage()));

		return erroMap;

	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String, String>  handleBusinessException(UserNotFoundException ue){
		
		Map<String, String> errorMap=new HashMap<>();
		errorMap.put("ErrorMessage", ue.getMessage());
		return errorMap;
	}

}