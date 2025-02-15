package com.sarthak.zoo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ArithmeticException.class)
	ProblemDetail handleArithmeticException(ArithmeticException e) 
	{
		String msg = "Arithmetic Exception: Division by zero";
		return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, msg);
	}

}
