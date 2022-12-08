package com.globallogic.mongo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.globallogic.mongo.customexception.*;

@RestControllerAdvice
public class EmployeeControllerAdvisory {
	
	@ExceptionHandler({EmployeeCustomException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleWalletException(EmployeeCustomException ex)
	{
		return ex.getMessage();
	}

}
