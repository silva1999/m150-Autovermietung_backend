/**
 * @author 	Leandro Silva
 * @date 	21.01.2019
 * @version	1.0
 * 
 * Own exception class
 */
package com.silva.carrent.exception;

public class NotEnoughMoneyException extends Exception{

	/**
	 * default constructor
	 */
	public NotEnoughMoneyException(){
		super("407");
	}
}
