package com.sunilos.p4.exception;

/**
 * RecordNotFoundException thrown when a record not found occurred
 * 
 * @auther Apurva Deshmukh
 * @version 1.0
 * @Copyright (c) Rays Technologies
 * 
 */

public class RecordNotFoundException extends RuntimeException {

	/**
	 * @param msg error message
	 */
	public RecordNotFoundException(String msg) {
		super(msg);

	}
}
