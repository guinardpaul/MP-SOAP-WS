/**
 * 
 */
package com.guinardsolutions.mp.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class Competence.
 *
 * @author Paul
 */
@Entity
@Table(name = "competences")
public class Competence extends AbstractDomaine implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1450639351136153713L;

	/**
	 * Instantiates a new competence.
	 */
	public Competence() {
		super();
	}

	/**
	 * Instantiates a new competence.
	 *
	 * @param ref
	 *            the ref
	 * @param description
	 *            the description
	 * @param cycle
	 *            the cycle
	 * @param abstractDomaine
	 *            the abstract domaine
	 */
	public Competence(String ref, String description, String cycle, AbstractDomaine abstractDomaine) {
		super(ref, description, cycle, abstractDomaine);
	}

}
