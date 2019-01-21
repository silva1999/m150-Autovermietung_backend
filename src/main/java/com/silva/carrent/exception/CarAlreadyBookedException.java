/**
 * @author 	Leandro Silva
 * @date 	21.01.2019
 * @version	1.0
 * 
 * Own exception class
 */
package com.silva.carrent.exception;

public class CarAlreadyBookedException extends Exception{

	/**
	 * default constructor
	 */
	public CarAlreadyBookedException(){
		super("406");
	}
}
