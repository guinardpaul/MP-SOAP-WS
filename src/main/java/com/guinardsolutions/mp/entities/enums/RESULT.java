/**
 * 
 */
package com.guinardsolutions.mp.entities.enums;

/**
 * The Enum RESULT.
 *
 * @author Paul
 */
public enum RESULT {

	/** The excellent. */
	excellent("++", 4),
	/** The good. */
	good("+", 3),
	/** The medium. */
	medium("+/-", 2),
	/** The bad. */
	bad("-", 1);

	/** The name. */
	private String name;

	/** The value. */
	private int value;

	/**
	 * Instantiates a new result.
	 *
	 * @param name
	 *            the name
	 * @param value
	 *            the value
	 */
	private RESULT(String name, int value) {
		this.name = name;
		this.value = value;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

}
