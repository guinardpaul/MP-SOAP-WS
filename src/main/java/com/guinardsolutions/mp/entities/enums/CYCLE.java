package com.guinardsolutions.mp.entities.enums;

// TODO: Auto-generated Javadoc
/**
 * CYCLE Enum.
 *
 * @author Paul
 */
public enum CYCLE {
	
	/** Cycle 3. */
	Cycle3("Cycle 3"),
	
	/** Cycle 4. */
	Cycle4("Cycle 4");

	/** The name. */
	private final String name;

	/**
	 * Instantiates a new cycle.
	 *
	 * @param name the name
	 */
	private CYCLE(String name) {
		this.name = name;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

}
