package com.globallogic.mongo.customexception;

@SuppressWarnings("serial")
public class EmployeeCustomException extends Exception {
	
	public EmployeeCustomException(String error)
	{
		super(error);
	}

}
