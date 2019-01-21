package com.silva.carrent.controller;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	 
    private HttpStatus httpStatus;
    private String message;
 
    public ErrorResponse(String code) {
        this.message = "Internal Server Error";
        this.httpStatus = getCorrectHttpStatus(code);
    }
    
    private HttpStatus getCorrectHttpStatus(String code){
    	try{
    		int statusCode = Integer.valueOf(code);
        	for(HttpStatus httpStatus : HttpStatus.values()){
        		if(httpStatus.value() == statusCode){
        			return httpStatus;
        		}
        	}
        	return HttpStatus.INTERNAL_SERVER_ERROR;
    	} catch(Exception ex){
    		return HttpStatus.INTERNAL_SERVER_ERROR;
    	}
    }

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
