/**
 *
 */
package com.guinardsolutions.mp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// TODO: Auto-generated Javadoc
/**
 * The Class AbstractDomaine.
 *
 * @author Paul
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractDomaine {

	/**
	 * The id.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;

	/**
	 * The ref.
	 */
	@Column(name = "ref")
	private String ref;

	/**
	 * The description.
	 */
	@Column(name = "description")
	private String description;

	/**
	 * The cycle.
	 */
	@Column(name = "cycle")
	private String cycle;

	/**
	 * The abstract domaine.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "abstract_domaine_id")
	private AbstractDomaine abstractDomaine;

	/**
	 * Instantiates a new abstract domaine.
	 */
	public AbstractDomaine() {
		super();
	}

	/**
	 * Instantiates a new abstract domaine.
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
	public AbstractDomaine(String ref, String description, String cycle, AbstractDomaine abstractDomaine) {
		super();
		this.ref = ref;
		this.description = description;
		this.cycle = cycle;
		this.abstractDomaine = abstractDomaine;
	}

	/**
	 * Gets the abstract domaine.
	 *
	 * @return the abstractDomaine
	 */
	public AbstractDomaine getAbstractDomaine() {
		return abstractDomaine;
	}

	/**
	 * Sets the abstract domaine.
	 *
	 * @param abstractDomaine
	 *            the abstractDomaine to set
	 */
	public void setAbstractDomaine(AbstractDomaine abstractDomaine) {
		this.abstractDomaine = abstractDomaine;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Gets the ref.
	 *
	 * @return the ref
	 */
	public String getRef() {
		return ref;
	}

	/**
	 * Sets the ref.
	 *
	 * @param ref
	 *            the ref to set
	 */
	public void setRef(String ref) {
		this.ref = ref;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the cycle.
	 *
	 * @return the cycle
	 */
	public String getCycle() {
		return cycle;
	}

	/**
	 * Sets the cycle.
	 *
	 * @param cycle
	 *            the cycle to set
	 */
	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

}
