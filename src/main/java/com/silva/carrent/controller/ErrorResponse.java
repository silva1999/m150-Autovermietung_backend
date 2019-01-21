/**
 * @author 	Leandro Silva
 * @date 	21.01.2019
 * @version	1.0
 * 
 * This class represents an error response.
 */
package com.silva.carrent.controller;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	 
    private HttpStatus httpStatus;
    private String message;
 
    /**
     * Constructor
     * @param code
     */
    public ErrorResponse(String code) {
        this.message = "Internal Server Error";
        this.httpStatus = getCorrectHttpStatus(code);
    }
    
    /**
     * This method searches the correct HTTPStatus
     * @param code
     * @return httpStatus object
     */
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

    /**
     * Getter method returns HttpStatus
     * @return httpStatus
     */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	/**
	 * Setter method sets HttpStatus
	 * @param httpStatus
	 */
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	/**
	 * Getter method returns error message
	 * @return error message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter method sets error message
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
}
